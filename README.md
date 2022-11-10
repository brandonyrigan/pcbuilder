# PC Builder

## Project Description

A standalone Java program that allows a Customer to custom build a personal PC from an existing 
inventory of PC Components. 

### User Story

#### Minimym Viable Product (MVP)
    - as a guest cutomer I should be able to input my information when promted
    - as a guest cutomer I would like to be prompted during my shopping experience
    - as a guest cutomer I would like to be displayed my current selections and current total price

    - as a guest cutomer I would like select a component from a live inventory and be specs so I can 
      decide which component to add to my pc build
    - as a guest cutomer I would like to be informed of my progress and when my build is complete

#### Stretch Goals

#### Types of Customer
- Guest Customer - can only initiate a session
    - name
    - phone
    - email
    - session id (uuid)
- Registered Customer
#### Shopping Cart Feature
    - edit/update
    - clear/trash
    - save (?)
#### Stretch Goals

- Pre-built PC
    - Gaming
    - Business
    - Designer
    - HighEnd

- User Class
    - ( in - memory ) users
    - name, email, phone, uuid, order id


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