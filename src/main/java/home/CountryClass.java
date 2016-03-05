package home;

/**
 * Created by Switch on 05.03.2016.
 */
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import home.wsdl.GetCountryRequest;
import home.wsdl.GetCountryResponse;
import home.wsdl.Country;
//import home.wsdl.Currency;


public class CountryClass extends WebServiceGatewaySupport{

    private String name;
    private String population;
    public String url = "http://localhost:8080/ws/countries.wsdl";

    void Country(){}

    public void setName(String name){this.name = name;}
    public String getName(){return  name;}


    public void setPopulation(String name){this.population = population;}
    public String getPopulation(){return  population;}
    GetCountryResponse getResponce = null;
    public GetCountryResponse getCountryResponse(String name){

        try {

            GetCountryRequest getRequest = new GetCountryRequest();
            getRequest.setName(name);
            System.out.println("good1");
            System.out.println(url);
            getResponce = (GetCountryResponse) getWebServiceTemplate()
                    .marshalSendAndReceive(getRequest,
                    new SoapActionCallback("http://localhost:8080/ws/countries.wsdl"));
            System.out.println(getResponce);

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            return  getResponce;
        }
    }

    public  void printResponce(GetCountryResponse inputResponce){
        Country country = inputResponce.getCountry();
        System.out.println(country.getCapital());

    }


}
