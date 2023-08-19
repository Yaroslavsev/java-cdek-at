package live_coding_18_08_2023;

import org.example.live_coding_18_08_2023.models.Get;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface GetService {
    @GET("users")
    Call<List<Get>> getUsers();
}
