package com.isuwang.soa.price.domain;

        import java.util.Optional;

        /**
         * Autogenerated by Dapeng-Code-Generator (1.2.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated

        *
        **/
        public class Price{
        
            /**
            *
            **/
            public int orderId ;
            public int getOrderId(){ return this.orderId; }
            public void setOrderId(int orderId){ this.orderId = orderId; }

            public int orderId(){ return this.orderId; }
            public Price orderId(int orderId){ this.orderId = orderId; return this; }
          
            /**
            *
            **/
            public double price ;
            public double getPrice(){ return this.price; }
            public void setPrice(double price){ this.price = price; }

            public double price(){ return this.price; }
            public Price price(double price){ this.price = price; return this; }
          

        public String toString(){
          StringBuilder stringBuilder = new StringBuilder("{");
            stringBuilder.append("\"").append("orderId").append("\":").append(this.orderId).append(",");
    stringBuilder.append("\"").append("price").append("\":").append(this.price).append(",");
    
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
            stringBuilder.append("}");

          return stringBuilder.toString();
        }
      }
      