<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS
Welcome to Java Frameworks! This is an opportunity for students to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.
FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## BASIC INSTRUCTIONS
For this project, you will use the Integrated Development Environment (IDE) link in the web links section of this assessment to install the IDE, IntelliJ IDEA (Ultimate Edition). All relevant links are on the course page. Please refer to the course of study for specific links. You will sign up for a free student license using your WGU.edu email address. Please see the “IntelliJ Ultimate Edition Instructions” attachment for instructions on how do this. Next you will download the “Inventory Management Application Template Code” provided in the web links section and open it in IntelliJ IDEA (Ultimate Edition). You will upload this project to a private external GitLab repository and backup regularly. As a part of this, you have been provided with a base code (starting point). 


C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

<pre>

    CHANGE - mainscreen.html
        Line 14 - &lt title &gt My Bicycle Shop &lt title &gt
        TO
        Line 14 - &lt title &gt Robinson's Computer Haven&lt /title &gt
        
        Line 19 - &lt h1 &gt Shop &lt /h1 &gt
        TO
        Line 19 - &lt h1 &gt Shop for Computer Parts & Accessories  &lt /h1 &gt
</pre>



D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
<pre>

    CREATE - about.html

        &lt !DOCTYPE html &gt  
        &lt html lang="en" &gt  
        &lt head &gt  
            &lt meta charset="UTF-8" &gt  
            &lt title &gt  About Us&lt /title &gt  
        &lt /head &gt  
        &lt body &gt  
        
            &lt p &gt  
            Robinson's Computer Haven is your shop for all things computer related.
    Our store is people driven and not profit driven. If we can't help then it's free 99.

            &lt /p &gt  
        
            &lt a href="http://localhost:8080/" &gt  Link to Main Screen&lt /a &gt  
        &lt /body &gt  
        &lt /html &gt  

    INSERT - mainscreen.html
    
        Line 89 to 90 - &lt  a th:href="@{/about}" style="float: right">
        Go To About Us &lt /a &gt

   CREATE - AboutController, LINES ALL

   package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String getAbout() {
        return "About";
    }
}

</pre>

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
<pre>

INSERT - BootStrapData.java, LINES 65-156

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
</pre>

Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.


F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.
<pre>
  CREATE - confirmationbuyproduct.html

        &lt !DOCTYPE html &gt 
        &lt html lang="en" &gt 
        &lt head &gt 
            &lt meta charset="UTF-8" &gt 
            &lt title &gt Product Purchase Confirmation &lt /title &gt 
        &lt /head &gt 
        &lt body &gt 
        &lt h1 &gt Your product has been purchased. &lt /h1 &gt 
        
        &lt a href="http://localhost:8080/" &gt Link to Main Screen &lt /a &gt 
        &lt /body &gt 
        &lt /html &gt 

    CREATE - errorbuyproduct.html

         &lt !DOCTYPE html &gt 
         &lt html lang="en" &gt 
         &lt head &gt 
             &lt meta charset="UTF-8" &gt 
             &lt title &gt Error purchasing product. &lt /title &gt 
         &lt /head &gt 
         &lt body &gt 
         &lt h1 &gt Error purchasing product. Confirm current inventory. &lt /h1 &gt 
        
         &lt a href="http://localhost:8080/" &gt Link to Main Screen &lt /a &gt 
        
         &lt /body &gt 
         &lt /html &gt 

    INSERT - mainscreen.html, LINES 85-86

        &lt a th:href="@{/buyproduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3"
        onclick="if(!(confirm('Are you sure you want to purchase this product?')))return false" &gt Buy Now &lt /a &gt 
    
    INSERT - product.java, LINES 108-116

        // Instruction F: buyProduct function to decrement inventory
        // Uses a simple test to ensure product exists before decrementing
        public boolean buyProduct() {
            if (this.inv >= 1 ) {
                this.inv--;
                return true;
            } else {
                return false;
            }
        
        }

    INSERT - AddProductController.java

        LINE 177 - @GetMapping("/buyproduct")
        LINE 178 - public String buyProduct(@RequestParam("productID") int theId, Model theModel ) {
        LINE 179 - ProductService productService = context.getBean(ProductServiceImpl.class);
        LINE 180 - Product product2 = productService.findById(theId);
        LINE 181 - 
        LINE 182 - boolean purchaseConfirmation = product2.buyProduct();
        LINE 183 - if ( purchaseConfirmation ) {
        LINE 184 -     productService.save(product2);
        LINE 185 -     return "confirmationbuyproduct";
        LINE 186 - }
        LINE 187 - 
        LINE 188 - return "errorbuyproduct";
        LINE 189 - }
</pre>

G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
<pre>
    INSERT - mainscreen.html, LINES 38-39 AND LINES 48-49
        &lt th &gt Minimum &lt /th &gt 
        &lt th &gt Maximum &lt /th &gt 

        &lt td th:text="${tempPart.minimum}" &gt 1 &lt /td &gt 
        &lt td th:text="${tempPart.maximum}" &gt 1 &lt /td &gt
</pre>
<br>
•  Modify the sample inventory to include the maximum and minimum fields.
<br>
<pre>
  INSERT - Part.java, LINES 32-35 AND LINES 104-108
        @Min (value = 0, message = "Minimum inventory must be > 0")
        int minimum;
        int maximum;

        public void setMinimum(int minimum) { this.minimum = minimum; }
        public int getMinimum() { return this.minimum; }
         
        public void setMaximum(int maximum) { this.maximum = maximum; }
        public int getMaximum() { return this.maximum; }

    NOTE: Added default min/max (0/100 respectively) to default constructors
    for both in house and outsource parts

    INSERT - InhousePart.java AND OutsourcedPart.java, LINES 18-19
        // Adding default values for maximum and minimum; can be changed in app
        this.minimum = 0;
        this.maximum = 100;

</pre>

•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
<pre>  
    INSERT - InhousePartForm.html AND OutsourcedPartForm.html, LINES 23-35

        &lt p &gt  &lt input type="text" th:field="*{minimum}" placeholder="Minimum" class="form-control mb-4 col-4"/ &gt  &lt /p &gt 
             
        &lt p &gt  &lt input type="text" th:field="*{maximum}" placeholder="Maximum" class="form-control mb-4 col-4"/ &gt  &lt /p &gt 
             
        &lt p &gt  &lt input type="text" th:field="*{partId}" placeholder="Part ID" class="form-control mb-4 col-4"/ &gt  &lt /p &gt 
    
        &lt p &gt 
        &lt div th:if="${#fields.hasAnyErrors()}" &gt 
            &lt ul &gt  &lt li th:each="err: ${#fields.allErrors()}" th:text="${err}" &gt  &lt /li &gt  &lt /ul &gt 
        &lt /div &gt 
        &lt /p &gt 
</pre>

•  Rename the file the persistent storage is saved to.
<pre>
   CHANGE - application.properties
        spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db102
        TO
        spring.datasource.url=jdbc:h2:file:~/src/main/resources/spring-boot-h2-db102

</pre>

•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.
<pre>
NOTE: This requirement is enforced from a code standpoint by a validateLimits() function that is called
by the save() function just before saving the part changes to the repository. If the value is
outside of the threshold (e.g. below the minimum or above the maximum) then inv is forcibly set
to the corresponding limit.

    INSERT - Part.java LINES 89-96
        public void validateLimits() {
            if (this.inv < this.minimum) {
                this.inv = this.minimum;
            } else if (this.inv > this.maximum ) {
                this.inv = this.maximum;
            }
        }

    INSERT - InhousePartServiceImpl.java AND OutsourcedPartServiceImpl.java, LINE 54... save()
        thePart.validateLimits();

NOTE: there are also validators in place to prevent the form from accepting a value for inventory
that is below the minimum or above the maximum, outlined in section H. 
</pre>



H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
<pre>
  INSERT - Part.java, LINES 19-20
        @ValidPartInventory
        @ValidPartInventoryMinimum

    CREATE PartInventoryMinimumValidator.java

        package com.example.demo.validators;

        import com.example.demo.domain.Part;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationContext;

        import javax.validation.ConstraintValidator;
        import javax.validation.ConstraintValidatorContext;

        public class PartInventoryMinimumValidator implements ConstraintValidator<ValidPartInventoryMinimum Part> {
            @Autowired
            private ApplicationContext context;

            public static  ApplicationContext myContext;

            @Override
            public void initialize(ValidPartInventoryMinimum constraintAnnotation) {
             ConstraintValidator.super.initialize(constraintAnnotation);
             }

            @Override
            public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
             return part.getInv() > part.getMinimum();
             }
        }

    CREATE ValidPartInventoryMinimum.java
        package com.example.demo.validators;


        import javax.validation.Constraint;
        import javax.validation.Payload;
        import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;

        @Constraint(validatedBy = {PartInventoryMinimumValidator.class})
        @Target({ElementType.TYPE})
        @Retention(RetentionPolicy.RUNTIME)
        
        public @interface ValidPartInventoryMinimum {
            String message() default "Inventory cannot be lower than required minimum";
            Class<?> [] groups() default {};
            Class<? extends Payload> [] payload() default {};
            }


</pre>
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
<pre>
  NOTE: There isn't a validator here because the requirements of section F is that the "Buy Now" button doesn't change the 
inventory of the associated parts. 

If I were to implement this feature, I would have needed to modify the buyProduct() 
function that I created to decrement the inventory of the parts as well like so:

    public boolean buyProduct() {
        if (this.inv >= 1 ) {
            this.inv--;

            for(Part part:this.getParts()){
                if (part.getInv() >= 1) {
                    part.setInv(part.getInv() - 1);
                } else {
                    return false;
                }
            }
    }

Then, I could have modified the errorbuypart.html to include the validation error that
would have been triggered by PartInventoryMinimumValidator.

</pre>

•  Display error messages when adding and updating parts if the inventory is greater than the maximum.

<pre>
 CREATE - PartInventoryValidator.java

        package com.example.demo.validators;
        
        import com.example.demo.domain.Part;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationContext;
        
        import javax.validation.ConstraintValidator;
        import javax.validation.ConstraintValidatorContext;
        
        /**
         *
         *
         *
         *
         */
        public class PartInventoryValidator implements ConstraintValidator &lt ValidPartInventory, Part &gt {
            @Autowired
            private ApplicationContext context;
        
            public static  ApplicationContext myContext;
        
            @Override
            public void initialize(ValidPartInventory constraintAnnotation) {
                ConstraintValidator.super.initialize(constraintAnnotation);
            }
        
            @Override
            public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
                return part.getInv() <= part.getMaximum();
            }
        }

    CREATE - ValidPartInventory.java

        package com.example.demo.validators;
        
        import javax.validation.Constraint;
        import javax.validation.Payload;
        import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;
        
        /**
         *
         *
         *
         *
         */
        @Constraint(validatedBy = {PartInventoryValidator.class})
        @Target({ElementType.TYPE})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ValidPartInventory {
            String message() default "Inventory cannot exceed maximum value";
            Class<?> [] groups() default {};
            Class<? extends Payload> [] payload() default {};
        }


</pre>

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
<pre>

  INSERT - PartTest.java, LINES 160-176
        @Test
        void getMinimum() {
            int minimum=5;
            partIn.setMinimum(minimum);
            assertEquals(minimum, partIn.getMinimum());
            partOut.setMinimum(minimum);
            assertEquals(minimum, partOut.getMinimum());
        }
    
        @Test
        void getMaximum() {
            int maximum=5;
            partIn.setMaximum(maximum);
            assertEquals(maximum, partIn.getMaximum());
            partOut.setMaximum(maximum);
            assertEquals(maximum, partOut.getMaximum());
        }

</pre>

J.  Remove the class files for any unused validators in order to clean your code.
<pre>

Unused validators review:
    ValidDeletePart (DeletePartValidator) - Used in Part.java 
        Prevents parts from being deleted if they're associated with a product

    ValidEnufParts (EnufPartsValidator) - Used in Product.java
        Prevents adding additional product inventory if there isn't enough associated parts inventory

    ValidPartInventory (PartInventoryValidator) - Used in Part.java
        Prevents adding additional part inventory if it exceeds the specified max

    ValidPartInventoryMinimum (PartInventoryMinimumValidator) - Used in Part.java
        Prevents modifying part inventory if it the changes puts it below the min threshold

    ValidProductPrice (PriceProductValidator) - Used in Product.java
        Prevents charging less for the product than the sum cost of its associated parts

All 5 validators in the project are being used. 

</pre>
