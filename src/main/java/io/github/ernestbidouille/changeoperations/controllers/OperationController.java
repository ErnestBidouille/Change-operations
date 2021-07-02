package io.github.ernestbidouille.changeoperations.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import io.github.ernestbidouille.changeoperations.models.Operation;
import io.github.ernestbidouille.changeoperations.models.OperationBuilder;
import io.github.ernestbidouille.changeoperations.models.Rate;
import io.github.ernestbidouille.changeoperations.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationController {
    @Autowired
    OperationService operationService;

    @GetMapping()
    private List<Operation> getAllOperation(@RequestParam(required = false) String sourceDevise, @RequestParam(required = false) String destinationDevise, @RequestParam(required = false) Date date, @RequestParam(required = false) Integer amount) {
        List<Operation> operations = new ArrayList<Operation>();
        List<Operation> tmpOperations = operationService.getAllOperations();
        tmpOperations.forEach(operation -> {
            if ((sourceDevise != null && !operation.getSourceDevise().equals(sourceDevise))
                    || (destinationDevise != null && !operation.getDestinationDevise().equals(destinationDevise))
                    || (amount != null && operation.getAmount() != amount)) {
                return;
            }
            if (date != null) {
                Instant filterDate = date.toInstant().plusSeconds(7200).truncatedTo(ChronoUnit.DAYS);
                Instant operationDate = operation.getDate().toInstant().truncatedTo(ChronoUnit.DAYS);
                if (!filterDate.equals(operationDate)) {
                    return;
                }
            }
            operations.add(operation);
        });
        return operations;
    }

    @GetMapping("/{operationId}")
    private Operation getOperation(@PathVariable("operationId") Long operationId) {
        return operationService.getOperationById(operationId);
    }

    @DeleteMapping("/{operationId}")
    private void deleteOperation(@PathVariable("operationId") Long operationId) {
        operationService.delete(operationId);
    }

    @PostMapping()
    private Long saveOperation(@RequestBody OperationBuilder operationBuilder) {
        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:8080/exchanges/lastExchangeRate?sourceDevise=" + operationBuilder.getSourceDevise() +
                        "&destinationDevise=" + operationBuilder.getDestinationDevise())
                .build();
        try {
            Response response = client.newCall(request).execute();
            Rate rate = mapper.readValue(response.body().byteStream(), Rate.class);
            Operation operation = new Operation(operationBuilder.getSourceDevise(),
                    operationBuilder.getDestinationDevise(),
                    operationBuilder.getAmount(),
                    new Date(System.currentTimeMillis()),
                    rate.getRate());
            operationService.saveOrUpdate(operation);
            return operation.getId();
        } catch (Exception e) {
            throw new IllegalArgumentException("Bad source or destination devise");
        }
    }

    @PutMapping()
    private Operation updateOperation(@RequestBody Operation operation) {
        operationService.saveOrUpdate(operation);
        return operation;
    }
}
