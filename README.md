# PC Builder

## Project Description

A standalone Java program that allows a Guest Customer to custom build a personal PC from an existing 
inventory of PC Components. 

### PC Build 

    - Terminal/CommandLine: Guided Walk Through 
        
            STEP 0 : ENTRY
                - get customer info
                - create new session for guest customer
                    - create new customer
                    - fetch current inventory
                - DECIDE: display permanent walk through banner to customer
                    - shows current build
                    - DECIDE: shows current total price
            
            STEP 1 : PC COMPONENTS
                - display permanent walk through banner to customer
                - customer selects subsequent components
                    - display live inventoy list of current component
                        - Example: if component is a processor
                                *******************************************************
                                insructions: select component

                                select    component      price    rating        des
                                  1      Processor A   $ double     *       lorem ipsum
                                  2      Processor B   $ double     *       lorem ipsum
                                  3      Processor C   $ double     *       lorem ipsum
                                *******************************************************
                    - capture customer input ( integer value )

            STEP 3 BUILD (complete)
                - message customer of successful build
                - display current build

            STEP 4 - SHOPPING CART
                - create shopping cart
                - prompt customer to: 
                    - add build to cart
                    - remove build from cart
                    - view shopping cart

            STEP 5 : ORDER      
                - create new order
                - display order to customer
                    - order meta data (order id, timestamp)
                    - display component price
                    - display total price
                    - display total price after tax
                - prompt customer to:
                    - return to cart ( display cart )
                    - proceed to payment

            STEP 6 : PAYMENT
                - prompt customer to select payment type
                    - crypto, credit/debit, paypal, IOU...

### Types of Customer 
  - Guest Customer - can only initiate a session
    - name
    - phone
    - email
    - session id (uuid)
  - Registered Customer
### Shopping Cart Feature
    - edit/update
    - clear/trash
    - save (?)
### Stretch Goals

  - Pre-built PC
    - Gaming
    - Business
    - Designer
    - HighEnd

  - User Class
    - ( in - memory ) users
    - name, email, phone, uuid, order id