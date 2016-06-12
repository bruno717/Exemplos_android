package br.com.bruno.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import br.com.bruno.retrofit.interfaces.IStringService;
import br.com.bruno.retrofit.models.Cliente;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String uri = "http://192.168.1.4:8080/";

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(uri)
                .build();

        IStringService service = retrofit.create(IStringService.class);

        Call<String> repos = service.getStringService(123456L);

        repos.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("script", "response: " + response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("script", "erro: " + t.getMessage());
            }
        });

        /*Call<Cliente> reposTipoConta = service.getCliente();

        reposTipoConta.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {

                if (response.body() != null) {

                    Cliente cliente = response.body();
                    Log.i("script", "response: id-" + cliente.getId() + " cpf-" + cliente.getPessoaFisica().getCpf() + " nome-" + cliente.getPessoaFisica().getPessoa().getNome());

                }
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {

                Log.i("script", "erro: " + t.getLocalizedMessage());
            }
        });*/

        /*reposTipoConta.enqueue(new Callback<List<TipoConta>>() {
            @Override
            public void onResponse(Call<List<TipoConta>> call, Response<List<TipoConta>> response) {
                if (response.body() != null) {
                    for (int i = 0; i < response.body().size(); i++) {
                        TipoConta conta = response.body().get(i);
                        Log.i("script", "response: " + conta.getDsTipoConta());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<TipoConta>> call, Throwable t) {
                Log.i("script", "erro: " + t.getMessage());
            }
        });*/


    }
}
