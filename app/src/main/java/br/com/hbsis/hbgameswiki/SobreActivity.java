package br.com.hbsis.hbgameswiki;

import android.animation.ArgbEvaluator;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class SobreActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    /**
     * Inicia  a atividade com um List<Model>
     * Cada posicao do List conterá uma imagem em png do André, aonde se encontra dentro da drawable
     * O Model inicia vazio,a cada posição se inicia um novo new model
     * No Adapter a exibição de cada model dentro do List será iniciada
     * O ViewPager se encontra dentro de uma biblioteca de suporte
     * Principal funcionalidade se designa em deslizar para direita ou para esquerda,
     * Contendo dentro desta ViewPager o adpter com a pré-visualização das imagens
     * O setPadding define o auto-preenchimento do conteúdo setado como se fosse uma margem.
     * Cria-se um Array contendo cada cor de fundo de cada ViewPager podendo setala no colors xml
     * No getResources sera instaciadoos recursos relacionados a xml ddas cores que se apresenteram no fundo do swipe
     *
     * @Author MatheusPereira
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);


        models = new ArrayList<>();
        models.add(new Model(R.drawable.andrewpp, "André", "Fumante"));
        models.add(new Model(R.drawable.andrewpp, "André", "Fumante"));
        models.add(new Model(R.drawable.andrewpp, "André", "Fumante"));
        models.add(new Model(R.drawable.andrewpp, "André", "Fumante"));
        models.add(new Model(R.drawable.andrewpp, "André", "Fumante"));
        models.add(new Model(R.drawable.andrewpp, "André", "Fumante"));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimary)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             *Este método se referencia-se a rolagem da tela, o quanto ele rolou conforme a largura da tela
             * O adapter.getCount retornara o numero de linhas no cursos e colors.lengh
             * Se as duas variaveis forem menor que a posição, ele pegará a imagem com as descrições
             * argbEvaluator fará com que calcule a cor numeros inteiros com valores inicial e final nos 4 bytes
             * onPageScrolled - Dentro deste método e fará com que ao rolar a cor troque para próxima posição senão volte para outra posição com outra ou mesma cor;
             *
             *
             * @Author MatheusPereira
             */

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }
            /*
            onPageSelected - Seleciona a posicao inicial em que se encontra na rolagem;
            @Author MatheusPereira
             */
            @Override
            public void onPageSelected(int position) {

            }
            /*
            onPageScrollStateChanged-Chamado quando o estado da rolagem muda. Útil para descobrir quando o usuário começa a arrastar ,se ele está na atual ou parado/inativo.
            @Author MatheusPereira
             */
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
