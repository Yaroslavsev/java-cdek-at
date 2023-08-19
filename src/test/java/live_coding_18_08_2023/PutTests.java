package live_coding_18_08_2023;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.live_coding_18_08_2023.models.Address;
import org.example.live_coding_18_08_2023.models.Company;
import org.example.live_coding_18_08_2023.models.Geo;
import org.example.live_coding_18_08_2023.models.Put;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PutTests {
    private static Retrofit retrofitPuts;

    private static PutService putsService;

    @BeforeClass
    public static void initPutsService() {
        Gson gson = new GsonBuilder().setLenient().create();

        retrofitPuts = new Retrofit
                .Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();

        putsService = retrofitPuts.create(PutService.class);
    }

    // Сайт https://jsonplaceholder.typicode.com/ НЕ поддерживает метод PUT для /users, но поддерживает его для /posts/{postId},
    // поэтому реализован тестовый метод testSuccessPutPost в PostsTests
    //-----------------------------------------------------------------------------------------
    // Ссылка на список поддерживаемых методов - https://jsonplaceholder.typicode.com/guide/#:~:text=faked%20as%20if.-,Updating%20a%20resource,-fetch(%27https
    @Test
    public void testUpdateFirstUser(){
        try {
            Response<List<Put>> putResponse = putsService.putUsers().execute();

            // Для проверки метода PUT передаю долготу - 81.1496
            Geo geo = new Geo(-37.3159, 81.1496);
            //-----------------------------------------------------------------------------------------
            Address address = new Address("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", geo);
            Company company = new Company("Romaguera-Crona", "Multi-layered client-server neural-net", "harness real-time e-markets");

            Put put = new Put(1,
                    "Leanne Graham",
                    "Bret",
                    "Sincere@april.biz",
                    address,
                    "1-770-736-8031 x56442",
                    "hildegard.org",
                    company);

            assertEquals(404, putResponse.code());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}