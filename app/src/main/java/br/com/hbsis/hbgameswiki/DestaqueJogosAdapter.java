package br.com.hbsis.hbgameswiki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;


public class DestaqueJogosAdapter extends PagerAdapter {

    /**
     * @NonNull Indica que um valor de retorno de parâmetro, campo ou método nunca pode ser nulo.
     */

    private List<DestaqueJogos> destaqueJogos;
    private LayoutInflater layoutInflater;
    private Context context;

    /**
     * Adaptador para a tela de destaque
     * <p>
     * Para exibir os jogos na tela principal como destaque foi nescessário desenvolver esse Adaptador pois ele
     * permite vincular a lista na qual retorna-rá objetos do tipo DestaqueJogos
     *
     * @param destaqueJogos Será nescessário definir uma list que terá como objetos a classe DestaqueJogos
     * @param context       Define o contexto da view
     * @Author Sandro Diego Adão
     */

    public DestaqueJogosAdapter(List<DestaqueJogos> destaqueJogos, Context context) {
        this.destaqueJogos = destaqueJogos;
        this.context = context;
    }

    /**
     * Retorno da quantidade de items na lista
     * <p>
     * Utiliza-se o getCount para retornar a quantidade de registros dentro da lista destaqueJogos, podendo assim utilizar
     * como índice em pesquisas.
     *
     * @return int getCount  Retorna a quantidade de registros dentro da lista
     * @Author Sandro Diego Adão
     */

    @Override
    public int getCount() {
        return destaqueJogos.size();
    }

    /**
     * Verifica se o objeto é da view
     * <p>
     * Utilizado na verificação de objetos é o mesmo que contem na view
     *
     * @param view   Define a view que será utilizada na verificação
     * @param object Define o objeto que será utilizado na view
     * @return boolean  'True' se for igual, 'False' se for diferente
     * @Author Sandro Diego Adão
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    /**
     * Inicializa a inserção dos itens dentro do ViewGroup
     * <p>
     * Esse método é utilizado para a inicialização de inserção dos jogs que serao exibidos na tela
     * de destaque.
     *
     * @param container Define o container ViewGroup a ser instanciado
     * @param position  Define o numero da posição dos objetos dentro do ViewGroup
     * @return Retorna um objeto da classe abstrata LayoutInflater
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.model_item, container, false);

        ImageView imagem_jogo;
        TextView titulo, descricao;

        // Define os atribuidos que serão ligados nas views aonde serão populadas.
        imagem_jogo = view.findViewById(R.id.imagem_jogo);
        titulo = view.findViewById(R.id.btn_generos);
        descricao = view.findViewById(R.id.descricao);

        // Define os valores a serem passados nas views
        imagem_jogo.setImageResource(destaqueJogos.get(position).getImagem());
        titulo.setText(destaqueJogos.get(position).getTitulo());
        descricao.setText(destaqueJogos.get(position).getDescricao());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Metodo onClick do card
            }
        });

        // Adiciona a view dentro do container, inicializa-se com o index 0
        container.addView(view, 0);
        return view;
    }

    /**
     * Remove o item definido passado por parâmetro
     * <p>
     * Método utilizado para remover o item passado dentro do parâmetro que contem dentro do
     * container.
     *
     * @param container Define o ViewGroup a ser utilizado
     * @param position  Define a posição dentro do container ViewGroup
     * @param object    Define o objeto a ser removido
     * @Author Sandro Diego Adão
     * @void
     */
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}