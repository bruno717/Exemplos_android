package br.com.bruno.retrofit.interfaces;

import java.util.List;

import br.com.bruno.retrofit.models.Cliente;
import br.com.bruno.retrofit.models.TipoConta;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Bruno on 05/03/2016.
 */
public interface IStringService {
    @GET("test")
    Call<String> getStringService(@Query("telefone") String telefone);

    @GET("test/tipo_conta")
    Call<List<TipoConta>> getTipoConta();

    @GET("test/cliente")
    Call<Cliente> getCliente();
}
