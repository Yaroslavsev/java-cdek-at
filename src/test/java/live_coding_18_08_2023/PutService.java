package live_coding_18_08_2023;

import org.example.live_coding_18_08_2023.models.Put;
import retrofit2.Call;
import retrofit2.http.PUT;

import java.util.List;

public interface PutService {
    @PUT("users")
    Call<List<Put>> putUsers();
}
