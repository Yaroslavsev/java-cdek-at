package live_coding_18_08_2023;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.live_coding_18_08_2023.models.Address;
import org.example.live_coding_18_08_2023.models.Company;
import org.example.live_coding_18_08_2023.models.Geo;
import org.example.live_coding_18_08_2023.models.Get;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GetTests {
    private static Retrofit retrofitGets;

    private static GetService getsService;

    @BeforeClass
    public static void initGetsService() {
        Gson gson = new GsonBuilder().setLenient().create();

        retrofitGets = new Retrofit
                .Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();

        getsService = retrofitGets.create(GetService.class);
    }

    @Test
    public void testContainsFirstUser() {
        try {
            Response<List<Get>> getResponse = getsService.getUsers().execute();

            // Очень странная штука - ответ возвращает долготу не 81.1496 как при запросе на /users, а 0.0
            Geo geo = new Geo(-37.3159, 0.0);
            //-----------------------------------------------------------------------------------------
            Address address = new Address("Kulas Light",
                    "Apt. 556",
                    "Gwenborough",
                    "92998-3874",
                    geo);
            Company company = new Company("Romaguera-Crona",
                    "Multi-layered client-server neural-net",
                    "harness real-time e-markets");

            Get get = new Get(1,
                    "Leanne Graham",
                    "Bret",
                    "Sincere@april.biz",
                    address,
                    "1-770-736-8031 x56442",
                    "hildegard.org",
                    company);

            assertTrue(getResponse.isSuccessful());
            assertTrue(getResponse.body().contains(get));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}