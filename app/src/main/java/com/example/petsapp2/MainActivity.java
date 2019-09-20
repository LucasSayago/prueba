package com.example.petsapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PetAdapter.PetAdapterListener , SearchView.OnQueryTextListener {

    private RecyclerView recyclerViewPet;
    private PetAdapter petAdapter;
    private List<Pet> petList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPet = findViewById(R.id.recyclerViewPet);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPet.setLayoutManager(linearLayoutManager);

        petList.add(new Pet("Rex","983216498","https://www.ecestaticos.com/imagestatic/clipping/dfd/996/dfd996d0c22dd7e69412274972f5598d/por-que-nos-parece-que-los-perros-sonrien-una-historia-de-30-000-anos.jpg?mtime=1558346796" ,"available"));
        petList.add(new Pet("Alaska","2173621984","https://www.nationalgeographic.com.es/medio/2019/09/09/bull-dog-ingles_043b09e1_800x800.jpg","available"));
        petList.add(new Pet("Aura","241619821","https://fotos01.laopiniondemurcia.es/mmp/2018/11/21/690x278/perro.jpg","available"));
        petList.add(new Pet("Ben","2389213821","http://static.t13.cl/images/sizes/1200x675/1532388113-auno886072.jpg","available"));
        petList.add(new Pet("Black","73299832","https://www.lavanguardia.com/r/GODO/LV/p5/WebSite/2018/02/19/Recortada/img_asanchezm_20180220-122740_imagenes_lv_terceros_istock-637000686-620-keOD-U44908829125wIC-992x558@LaVanguardia-Web.jpg","available"));
        petList.add(new Pet("Calvin","85732852","https://cnnespanol2.files.wordpress.com/2019/08/gatos-felinos-mininos-gatito.jpg?quality=100&strip=info","available"));
        petList.add(new Pet("Joya","824217532","https://assets.entrepreneur.com/content/3x2/2000/20190718145450-perrito.jpeg?width=700&crop=2:1","available"));
        petList.add(new Pet("Kingo","385632325","https://wakyma.com/blog/wp-content/uploads/2017/03/La-vida-con-un-conejo-como-mascota","available"));
        petList.add(new Pet("Hamlet","875093275","https://www.lavanguardia.com/r/GODO/LV/p6/WebSite/2019/04/02/Recortada/img_mrius_20190402-141602_imagenes_lv_terceros_gato_nombre2-328-kLmH-U461425413181OZB-992x558@LaVanguardia-Web.jpg","available"));
        petList.add(new Pet("Angus","4328572","https://i2-prod.bristolpost.co.uk/incoming/article2890708.ece/ALTERNATES/s615/0_Marmalade-the-Hamster-has-fun-in-his-cage.jpg","available"));
        petList.add(new Pet("Bill","8433249","https://www.petalatino.com/wp-content/uploads/SXC-1078072.jpg","available"));
        petList.add(new Pet("Bobby","38652986","https://img.elcomercio.pe/files/article_content_ec_fotos/uploads/2017/09/05/59ae9c4faf0d5.jpeg","available"));
        petList.add(new Pet("Hercules","859843253","https://bucket3.glanacion.com/anexos/fotos/89/3032789w380.jpg","available"));
        petList.add(new Pet("Galaxy","98327529","https://www.780am.com.py/wp-content/uploads/2019/09/gatos-feilinos-mininos-2.png","available"));
        petList.add(new Pet("Osiris","945093","http://www.conejopedia.com/wp-content/uploads/2014/07/tumblr_n1n8h1oMcf1rcavgdo6_500.jpg","available"));
        petList.add(new Pet("Oko","9849683","https://t1.fr.ltmcdn.com/es/posts/8/0/1/frases_de_perros_108_600.jpg","available"));
        petList.add(new Pet("Zip","7329842","https://static.emol.cl/emol50/Fotos/2019/04/10/file_20190410173249.jpg","available"));
        petList.add(new Pet("Punner","99803294","https://hips.hearstapps.com/es.h-cdn.co/mcres/images/mi-casa/terraza-jardines-porche/consejos-para-cuidar-hamster/1729995-3-esl-ES/como-tener-un-hamster-mas-feliz-que-una-perdiz.jpg?crop=1.00xw:0.502xh;0,0.215xh&resize=480:*","available"));
        petList.add(new Pet("Ted","53295732","https://www.cookieswil.com/media/blog/870x/min/2619-214634-el-estrenimiento-en-perros-sintomas-causas-y-tratemiento.jpg","available"));
        petList.add(new Pet("Ziko","48348121","https://m.eldiario.es/consumoclaro/perros-television-dogtv-vision_EDIIMA20151102_0551_1.jpg","available"));
        petList.add(new Pet("Snap","832989325","https://www.consumer.es/wp-content/uploads/2019/07/img_celo-gatas-gatos.jpg","available"));


        petAdapter = new PetAdapter(petList, this);
        recyclerViewPet.setAdapter(petAdapter);
    }

    @Override
    public void informarSeleccion(Pet pet) {
        Toast.makeText(this, "Seleccionaron a " + pet.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("Name", pet.getName());
        bundle.putString("Photo", pet.getPhoto());
        bundle.putString("Status",pet.getStatus());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_buscador,menu);
        MenuItem item = menu.findItem(R.id.buscador);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                petAdapter.setFilter(petList);
                return true;
            }
        });
        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        try {

            ArrayList<Pet> listaFiltrada = filter((ArrayList<Pet>) petList, newText);
            petAdapter.setFilter(listaFiltrada);

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private ArrayList<Pet> filter (ArrayList<Pet> petList, String texto){
        ArrayList<Pet> listaFiltrada = new ArrayList<>();

        try {
            texto = texto.toLowerCase();

            for (Pet pet : petList){
                String pet2 = pet.getName().toLowerCase();

                if(pet2.contains(texto)){
                    listaFiltrada.add(pet);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        } return listaFiltrada;
    }
}
