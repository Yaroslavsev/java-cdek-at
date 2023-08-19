package live_coding_18_08_2023;

import org.example.live_coding_18_08_2023.models.Post;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface PostsService {
    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{postId}")
    Call<Post> getPost(@Path("postId") Integer postId);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @PUT("posts/{postId}")
    Call<Post> putPost(@Path("postId") Integer postId);
}
