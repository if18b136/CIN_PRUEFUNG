package at.technikumwien.pruefung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DBInitializer {
    @Autowired
    private CarRepository carRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void handleApplicationEvent() {
        carRepository.saveAll(
                List.of(
                        new Car(
                                null,
                                "Renault",
                                "Clio",
                                2008
                        ),
                        new Car(
                                null,
                                "Range Rover",
                                "Land Cruiser",
                                2018
                        )
                )
        );
    }
}
