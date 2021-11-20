package com.bykov.testspec.bootstrap;

import com.bykov.testspec.model.Address;
import com.bykov.testspec.model.Booze;
import com.bykov.testspec.model.Country;
import com.bykov.testspec.model.Type;
import com.bykov.testspec.repository.AddressRepository;
import com.bykov.testspec.repository.BoozeRepository;
import com.bykov.testspec.repository.spec.BoozeSpecifications;
import com.bykov.testspec.service.BoozeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BDBootstrap implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final BoozeRepository boozeRepository;
    private final BoozeService boozeService;

    public BDBootstrap(AddressRepository addressRepository, BoozeRepository boozeRepository, BoozeService boozeService) {
        this.addressRepository = addressRepository;
        this.boozeRepository = boozeRepository;
        this.boozeService = boozeService;
    }
    @Override
    public void run(String... args) throws Exception {
        Address belgiumAddress = new Address(Country.BELGIUM, "Karolana, 12");
        addressRepository.save(belgiumAddress);
        Address italyAddress = new Address(Country.ITALY, "Faramara, 4");
        addressRepository.save(italyAddress);
        Address spainAddress = new Address(Country.SPAIN, "Marafara, 113");
        addressRepository.save(spainAddress);
        Address russiaAddress = new Address(Country.RUSSIA, "Lenina, 9");
        addressRepository.save(russiaAddress);
        Address romaniaAddress = new Address(Country.ROMANIA, "Byzymyzy, 17");
        addressRepository.save(romaniaAddress);
        Address usaAddress = new Address(Country.USA, "St.Patrick, 127");
        addressRepository.save(usaAddress);

        Booze cognac = new Booze(Arrays.asList(belgiumAddress, usaAddress, russiaAddress),Type.COGNAC);
        boozeRepository.save(cognac);
        Booze whiskey = new Booze(Arrays.asList(belgiumAddress, usaAddress, spainAddress, italyAddress),Type.WHISKEY);
        boozeRepository.save(whiskey);
        Booze vodka = new Booze(Arrays.asList(russiaAddress, spainAddress),Type.VODKA);
        boozeRepository.save(vodka);
        Booze liquor = new Booze(Arrays.asList(romaniaAddress),Type.LIQUOR);
        boozeRepository.save(liquor);
        Booze wine = new Booze(Arrays.asList(romaniaAddress, italyAddress),Type.WINE);
        boozeRepository.save(wine);
        Booze beer = new Booze(Arrays.asList(belgiumAddress, usaAddress, russiaAddress, italyAddress, spainAddress),Type.BEER);
        boozeRepository.save(beer);

        Specification<Booze> boozeNotInEurope = BoozeSpecifications.boozeNotInEurope();
        Specification<Booze> hardBooze = BoozeSpecifications.hardBooze();

        System.out.println(boozeService.findAll(boozeNotInEurope));
        boozeService.findAll(hardBooze).forEach(booze -> System.out.println((booze.getBoozeType())));
    }
}
