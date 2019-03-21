package pl.coderslab.fixtures;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.PublisherRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublisherFixtures {


    @Autowired
    PublisherRepository publisherRepository;

    public void createAndInsertIntoDb() {
        List<Publisher> publishers = createPublishers();
        publisherRepository.save(publishers);
    }


    public List<Publisher> createPublishers() {

        List<Publisher> publishers = new ArrayList<>();

        Publisher pub1 = new Publisher();
        pub1.setName("PWN");
        pub1.setRegon("771822363");
        pub1.setNip("8126279487");

        Publisher pub2 = new Publisher();
        pub2.setName("HELIOS");
        pub2.setRegon("771822363");
        pub2.setNip("8126279487");


        publishers.add(pub1);
        publishers.add(pub2);

        return publishers;
    }


}
