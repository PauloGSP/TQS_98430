package stocks;




import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@ExtendWith(MockitoExtension.class)
public class StockTest {

    @InjectMocks 
    StockPortofolio portofolio;

    @Mock
    IStockmarketService service;








    
    @Test
    void getTotalValueTest() {

        Mockito.when( service.getPrice("Tesla")).thenReturn(3.5);
        Mockito.when( service.getPrice("Opel")).thenReturn(5.0);
        Mockito.when( service.getPrice("Marcodonaldo")).thenReturn(1.0);
        Mockito.when( service.getPrice("BImbo")).thenReturn(10.0);

        portofolio.addStock(new Stock("Tesla", 3));
        portofolio.addStock(new Stock("Opel", 4));
        portofolio.addStock(new Stock("Marcodonaldo", 1));
        portofolio.addStock(new Stock("BImbo", 10));

        double result = portofolio.getTotalValue();

        //assertEquals(30.5, result);
        assertThat(result, is(131.5));
        Mockito.verify(service, Mockito.times(4)).getPrice(Mockito.anyString());

    }
}
