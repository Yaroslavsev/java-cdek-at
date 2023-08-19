package live_coding_18_08_2023;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.live_coding_18_08_2023.models.Post;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PostsTest {
    private static Retrofit retrofitPosts;
    private static PostsService postsService;

    @BeforeClass
    public static void initPostsService() {
        Gson gson = new GsonBuilder().setLenient().create();

        retrofitPosts = new Retrofit
                .Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();

        postsService = retrofitPosts.create(PostsService.class);
    }

    @Test
    public void testContainsFirstPost() {
        try {
            Response<List<Post>> postResponse = postsService.getPosts().execute();

            Post post = new Post(1,
                    1,
                    "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                    "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");

            assertTrue(postResponse.isSuccessful());
            assertTrue(postResponse.body().contains(post));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSuccessCreateNewPost() {
        Post post = new Post(1,
                777777,
                "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");

        try {
            Response<Post> postCreateAnswer = postsService.createPost(post).execute();

            assertTrue(postCreateAnswer.isSuccessful());
            assertEquals(postCreateAnswer.body().getBody(), post.getBody());
            assertEquals(postCreateAnswer.body().getTitle(), post.getTitle());
            assertEquals(postCreateAnswer.body().getUserId(), post.getUserId());

            Response<Post> postCheckExistsAnswer = postsService
                    .getPost(postCreateAnswer
                            .body()
                            .getId())
                    .execute();

            assertTrue(postCheckExistsAnswer.isSuccessful());
            assertEquals(postCheckExistsAnswer.body().getBody(), post.getBody());
            assertEquals(postCheckExistsAnswer.body().getTitle(), post.getTitle());
            assertEquals(postCheckExistsAnswer.body().getUserId(), post.getUserId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Реализация проверки метода PUT
    @Test
    public void testSuccessPutPost() {
        Post post = new Post(999,
                1,
                "test title",
                "test body");

        try {
            Response<Post> postPutAnswer = postsService.createPost(post).execute();

            assertTrue(postPutAnswer.isSuccessful());
            assertEquals(postPutAnswer.body().getUserId(), post.getUserId());
            assertEquals(postPutAnswer.body().getTitle(), post.getTitle());
            assertEquals(postPutAnswer.body().getUserId(), post.getUserId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
