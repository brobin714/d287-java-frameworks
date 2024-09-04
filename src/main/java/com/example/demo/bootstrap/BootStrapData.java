package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        // Clearing repositories for multiple test runs
        // partRepository.deleteAll();
        // productRepository.deleteAll();
        // outsourcedPartRepository.deleteAll();

        if (partRepository.count() == 0) {

            InhousePart dram100 = new InhousePart();
            dram100.setName("DRAM100");
            dram100.setPrice(19.99);
            dram100.setInv(10);

            InhousePart dram200 = new InhousePart();
            dram200.setName("DRAM200");
            dram200.setPrice(29.99);
            dram200.setInv(10);

            InhousePart dram300 = new InhousePart();
            dram300.setName("DRAM300");
            dram300.setPrice(39.99);
            dram300.setInv(10);

            InhousePart dram400 = new InhousePart();
            dram400.setName("DRAM400");
            dram400.setPrice(49.99);
            dram400.setInv(10);

            InhousePart dram500 = new InhousePart();
            dram500.setName("DRAM500");
            dram500.setPrice(59.99);
            dram500.setInv(10);

            partRepository.save(dram100);
            partRepository.save(dram200);
            partRepository.save(dram300);
            partRepository.save(dram400);
            partRepository.save(dram500);
        }

        if (outsourcedPartRepository.count() == 0) {

            OutsourcedPart ssd1100 = new OutsourcedPart();
            ssd1100.setName("ssd1100");
            ssd1100.setPrice(19.99);
            ssd1100.setInv(10);
            ssd1100.setCompanyName("OthelloCorp");

            OutsourcedPart ssd2200 = new OutsourcedPart();
            ssd2200.setName("ssd2200");
            ssd2200.setPrice(29.99);
            ssd2200.setInv(10);
            ssd2200.setCompanyName("OthelloCorp");

            OutsourcedPart ssd3300 = new OutsourcedPart();
            ssd3300.setName("ssd3300");
            ssd3300.setPrice(39.99);
            ssd3300.setInv(10);
            ssd3300.setCompanyName("OthelloCorp");

            OutsourcedPart ssd4400 = new OutsourcedPart();
            ssd4400.setName("ssd4400");
            ssd4400.setPrice(49.99);
            ssd4400.setInv(10);
            ssd4400.setCompanyName("OthelloCorp");

            OutsourcedPart ssd5500 = new OutsourcedPart();
            ssd5500.setName("ssd5500");
           ssd5500.setPrice(59.99);
           ssd5500.setInv(10);
           ssd5500.setCompanyName("OthelloCorp");

            outsourcedPartRepository.save(ssd1100);
            outsourcedPartRepository.save(ssd2200);
            outsourcedPartRepository.save(ssd3300);
            outsourcedPartRepository.save(ssd4400);
            outsourcedPartRepository.save(ssd5500);
        }

        if (productRepository.count() == 0 ) {

            Product rx710 = new Product("FX710", 199.99, 15);
            Product rx720 = new Product("FX720", 299.99, 15);
            Product rx730 = new Product("FX730", 399.99, 15);
            Product rx740 = new Product("FX740", 499.99, 15);
            Product rx750 = new Product("FX750", 599.99, 15);

            productRepository.save(rx710);
            productRepository.save(rx720);
            productRepository.save(rx730);
            productRepository.save(rx740);
            productRepository.save(rx750);
        }


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
