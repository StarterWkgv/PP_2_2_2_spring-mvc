package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class CarServiceImp implements CarService {
    private final List<Car> list;

    {
        List<String> colour = List.of("green", "black", "yellow", "white", "blue");
        list = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> new Car(i, "Car " + i, colour.get((int)(Math.random() * 4) + 1))).toList();
    }

    @Override
    public List<Car> getList(int count) {
        if (count < 0) {
            return Collections.emptyList();
        }
        return list.stream().limit(Math.min(count, list.size())).toList();
    }
}
