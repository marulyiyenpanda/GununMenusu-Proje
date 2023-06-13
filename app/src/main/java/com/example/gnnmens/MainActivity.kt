package com.example.gnnmens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gnnmens.Adapter.dishAdapter
import com.example.gnnmens.Model.Meal
import com.example.gnnmens.databinding.ActivityMainBinding

import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private var arrayMeal = ArrayList<Meal>()
    private var arrayMainCourse = ArrayList<Meal>()
    private var arraySideDish = ArrayList<Meal>()
    private var selectedMeals = ArrayList<Meal>() // Seçili yemekleri tutacak ArrayList
    lateinit var oneri: Button
    private lateinit var dishAdapter: dishAdapter
    private lateinit var mainAdapter: dishAdapter
    private lateinit var sideDishAdapter: dishAdapter

    private lateinit var dishRecycler: RecyclerView
    private lateinit var mainRecycler: RecyclerView
    private lateinit var sideDishRecycler: RecyclerView

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dishRecycler = binding.dishrec
        mainRecycler = binding.mainrec
        sideDishRecycler = binding.sidedishrec

        dishAdapter = dishAdapter()
        mainAdapter = dishAdapter()
        sideDishAdapter = dishAdapter()

        dishRecycler.adapter = dishAdapter
        mainRecycler.adapter = mainAdapter
        sideDishRecycler.adapter = sideDishAdapter

        setupDishData()
        setupMainCourseData()
        setupSideDishData()

        dishAdapter.setData(arrayMeal)
        mainAdapter.setData(arrayMainCourse)
        sideDishAdapter.setData(arraySideDish)

        dishRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mainRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        sideDishRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        addToCart()
        oneri = findViewById(R.id.oneributton)
        oneri.setOnClickListener {
            val intent = Intent(this, OneriMenuler::class.java)
            startActivity(intent)
        }
    }

    private fun addToCart() {
        val mealName = "Tavuk Sote" // Yemek adını burada belirtin
        val mealImageResource = R.drawable.etsote // Yemek resminin kaynak ID'sini burada belirtin

        val meal = Meal(
            mealName,
            mealImageResource,
            "Yemek tarifi burada belirtilebilir."
        ) // Yeni bir Meal nesnesi oluşturun


        val cartList: MutableList<Meal> = mutableListOf()
        cartList.add(meal)


        Toast.makeText(this, "Yemek sepete eklendi.", Toast.LENGTH_SHORT).show()
    }


    private fun setupDishData() {
        arrayMeal.add(
            Meal(
                "Ezogelin Çorbası",
                R.drawable.ezogelin,
                "Ezogelin Çorbası Yapılışı Tarifi İçin Malzemeler\n" +
                        "1 su bardağı kırmızı mercimek\n" +
                        "1 tatlı kaşığı pirinç\n" +
                        "1 tatlı kaşığı bulgur\n" +
                        "2 çay kaşığı pul biber\n" +
                        "1 yemek kaşığı nane\n" +
                        "2 diş sarımsak\n" +
                        "1 orta boy soğan\n" +
                        "1 yemek kaşığı biber salçası\n" +
                        "1 yemek kaşığı tereyağı\n" +
                        "2 litreye yakın sıcak su\n" +
                        "Tuz\n\nEzogelin çorbası yapmak için düdüklü tencerede önce rendelemiş olduğumuz soğanı ve ezmiş olduğumuz sarımsağı tereyağında kavuruyoruz. Soğanlar diriliğini kaybetsin yeterli yakmadan orta ateşte kavuralım.\n" +
                        "Soğanlar kavrulunca naneyi, kırmızı biberi ve salçayı ilave edip. Kavurmaya devam edelim.\n" +
                        "Bir iki karıştırdıktan sonra yıkadığımız mercimeği, pirinci, bulguru ve tuzunu da ilave ederek karıştıralım.\n" +
                        "Başka bir tarafta kaynamakta olan 2 litreye yakın suyu üzerine boşaltalım.\n" +
                        "Düdüklünün kapağını ve düdüğünü kapattıktan sonra 10 dakika pişiriyoruz. Normal tencerede de yapabilirsiniz ama biraz daha geç pişecektir (yaklaşık 30-40 dakika sürecektir)."
            )
        )
        arrayMeal.add(
            Meal(
                "Kremalı Mantar Çorbası",
                R.drawable.kremalimantar,
                "Harika Kremalı Mantar Çorbası Tarifi İçin Malzemeler\n" +
                        "400 gram mantar\n" +
                        "1 adet orta boy kuru soğan\n" +
                        "1-2 yemek kaşığı un\n" +
                        "1,5 su bardağı süt veya 200 ml sıvı krema\n" +
                        "3 yemek kaşığı sıvı yağ\n" +
                        "1 yemek kaşığı tereyağı\n" +
                        "Tuz\n" +
                        "Karabiber\n" +
                        "1 tutam taze maydanoz\n" +
                        "3,5 su bardağı oda sıcaklığında su\n\n" +
                        "Not Ekle\n" +
                        "Tarifi Yazdır\n" +
                        "Mantarları güzelce yıkayalım ve saplarını çıkarıp küp küp doğrayalım.\n" +
                        "Sıvı yağ ve tereyağı tencereye koyup ince ince doğradığımız soğanı ekleyelim ve biraz pembeleşince, doğradığımız mantarları da ilave edelim ve suyunu salıp çekene kadar kavuralım.\n" +
                        "Daha sonra, unu ekleyip 1 dakika daha kavurduktan sonra, 1,5 su bardağı sütü\uD83D\uDC49(arzu eden paket krema da kullanabilir ama ben sütle yapıyorum gayet güzel oluyor) suyunu da ekleyip orta hararetli ateşte kaynamaya başlayana kadar karıştırarak pişirin.\n" +
                        "Altını kısıp 10 dakika kadar kaynatın.\n" +
                        "Ateşten almadan tuz ve karabiberini ve ince ince doğradığımız maydanozları da ekleyip bir taşım daha kaynatın çorbamız hazırdır. Afiyet olsun\uD83D\uDE0A"
            )
        )
        arrayMeal.add(
            Meal(
                "Mercimek Çorbası",
                R.drawable.mercimek,
                "Mercimek Çorbası Tarifi İçin Malzemeler\n" +
                        "2 su bardağı kırmızı mercimek\n" +
                        "1 adet soğan\n" +
                        "2 yemek kaşığı un\n" +
                        "1 adet havuç\n" +
                        "Yarım yemek kaşığı biber ya da  domates salçası (rengi kırmızı olsun isterseniz artırabilir ya da hiç kullanmayabilirsiniz)\n" +
                        "1 tatlı kaşığı tuz\n" +
                        "Yarım çay kaşığı karabiber\n" +
                        "1 çay kaşığı kimyon (isteğe bağlı)\n" +
                        "2 litre sıcak su\n" +
                        "5 yemek kaşığı sıvı yağ\n" +
                        "Sosu için:\n" +
                        "\n" +
                        "2 yemek kaşığı tereyağı\n" +
                        "1 tatlı kaşığı kırmızı toz biber\n\n" +
                        "Kırmızı mercimek çorbası için sıvı yağı tencereye alınarak yemeklik doğranan soğanlar hafif pembeleşinceye kadar kavrulur.\n" +
                        "Daha sonra un ilave edilerek kısık ateşte kavurmaya devam edilir.\n" +
                        "Salça kullanılacak ise salça ilave edilir, kavrulduktan sonra küp küp doğranmış havuç ve iyice yıkanıp suyu süzülen mercimekler ilave edilir.\n" +
                        "Üzerine su eklenerek karıştırılır ve tencerenin kapağı kapatılır. Çorbamız kaynayana kadar orta ateşte, kaynadıktan sonra mercimekler ve havuçlar yumuşayana kadar ara ara karıştırılarak kısık ateşte pişirilir.\n" +
                        "Çorba piştikten sonra el blenderı ile güzelce ezilir. Eğer blenderiniz yoksa süzgeçten de geçirebilirsiniz.\n" +
                        "Karabiber, tuz ve isteğe bağlı olarak kimyon eklenir ve karıştırılır. 5 dakika daha pişirelerek ocaktan alınır.\n" +
                        "Kıvamı koyu gelirse size, bir miktar su ilave edilerek bir taşım kaynatılır.\n" +
                        "Bu arada küçük bir tavaya iki yemek kaşığı tereyağı alınır, kızdırılır ve bir tatlı kaşığı kırmızı toz biber eklenerek ocaktan alınır.\n" +
                        "Mercimek çorbası servis kasesine alındıktan sonra üzerine kırmızı biberli sos gezdirilir ve bir dilim limon ile servis edilir."
            )
        )
        arrayMeal.add(
            Meal(
                "Tarhana Çorbası", R.drawable.tarhana, "Tarhana Çorbası Tarifi İçin Malzemeler\n" +
                        "3 yemek kaşığı ev tarhanası\n" +
                        "1 yemek kaşığı nane\n" +
                        "2 yemek kaşığı sıvı yağ\n" +
                        "1 yemek kaşığı salça\n" +
                        "6 su bardağı su\n" +
                        "Kırmızı pul biber\n" +
                        "Karabiber\n" +
                        "Tuz\n\n" +
                        "Tenceremizin içerisine sıvı yağ, nane, salça, baharatlar ve tarhanayı ekleyip biraz karıştırarak kavuruyoruz. Dilerseniz tereyağı da kullanabilirsiniz.( Veya tarhanayı suyu ekledikten sonra ekleyip çırpıcı ile karıştırabilirsiniz. böylelikle topaklanma ihtimali azalır.)\n" +
                        "Suyu yavaş yavaş ilave ediyoruz ve devamlı karıştırarak pişiriyoruz. Topaklanmaması için tel çırpıcı ile karıştırabilirsiniz. (kaynayana kadar karıştırarak pişirelim.)\n" +
                        "Kaynadıktan sonra 5 dk daha bekleyip ocaktan alıyoruz, çorbamızı…\n" +
                        "Afiyet olsun."
            )
        )
        arrayMeal.add(
            Meal(
                "Tavuksuyu Çorbası",
                R.drawable.tavuksuyu,
                "Terbiyeli Tavuk Suyu Çorbası Tarifi İçin Malzemeler\n" +
                        "Tavuğun istediğiniz her hangi bir yeri derili olmalı (1 tam büyük but kafi gelir)\n" +
                        "1 çorba kaşığı un\n" +
                        "1 çorba kaşığı tereyağı\n" +
                        "2 çorba kaşığı sıvı yağ\n" +
                        "Tuz\n" +
                        "Pul biber\n" +
                        "3 avuç tel şehriye\n" +
                        "2-3 dal maydanoz\n" +
                        "Terbiye için:\n" +
                        "\n" +
                        "Yarım limon suyu\n" +
                        "1 yumurta sarısı\n\n" +
                        "Öncelikle tavukları haşlıyoruz. Ben küçük bir tencerede az miktarda yaptığım için ölçü böyle ve tavuk az siz miktarı ve tavuğu arttırıp daha fazla yapın her şeyin 2 katı size ölçü olabilir. Bu ölçüler ile minik bir tencere çıkıyor.\n" +
                        "Tavuğu haşlayıp başka bir kaba suyunu süzelim.\n" +
                        "Tenceremizde tereyağı ve sıvı yağı eritip unu ekleyip kokusu çıkana kadar kavuralım.\n" +
                        "Sonra tavuk suyunu ekleyelim.\n" +
                        "Üzerine 1 bardak kadar da normal kaynar su ekleyelim. Eğer tavuk suyu tam gelirse başka suya gerek yok ama kesin gerekiyor çünkü kaynarken tavuk suyu biraz kayıp yaşıyor unutmamak lazım.\n" +
                        "O suda kaynara çıkınca tel şehriye ekleyelim.\n" +
                        "Başka bir yerde bir yumurta sarısı ve yarım limon suyu ile terbiye hazırlayalım.\n" +
                        "İşte bu kısım çok önemli. Çorbamızın kesilmemesi için; Terbiyeyi bir elle karıştırarak içine sıcak çorbadan alıp hemen karıştıralım terbiye iyice karışana kadar bu işlemi yapalım sonra çorbayı karıştıra karıştıra tencereye dökelim ve kaynara çıkana kadar sürekli karıştıralım ki kesilmesin. En önemli kısım burasıdır.\n" +
                        "Daha sonra indirmeye yakın pul biber, karabiber ,tuz ve biraz maydanoz ekleyip 5 dk. daha kaynatıp altını kapayalım."
            )
        )
        arrayMeal.add(
            Meal(
                "Tel Şehriye Çorbası",
                R.drawable.telsehriye,
                "Domatesli Tel Şehriye Çorbası Tarifi İçin Malzemeler\n" +
                        "1 çay bardağı tel şehriye\n" +
                        "2 adet domates\n" +
                        "1 yemek kaşığı sıvı yağ\n" +
                        "1 yemek kaşığı tereyağı\n" +
                        "Yarım yemek kaşığı salça\n" +
                        "5 su bardağı su\n" +
                        "1 tatlı kaşığı nane\n" +
                        "Tuz (1 tatlı kaşığı kadar)\n\n" +
                        "Öncelikle sıvı yağı ve tereyağını tencereye alın ve eritin\n" +
                        "Ardından salçayı ekleyip kokusu çıkana kadar kavurun.\n" +
                        "Salça güzelce kavrulduktan sonra rendelenmiş domatesleri ekleyip domatesler pişene kadar kavurun.\n" +
                        "Domatesler kavrulup suyunu çektikten sonra naneyi, tuzu ve ardından suyu ekleyin.\n" +
                        "Su kaynamaya başladığında ocağı orta ateşe alarak şehriyeleri ekleyin.\n" +
                        "Ara ara karıştırarak şehriyeler pişene kadar çorbayı kaynatın.\n" +
                        "Şehriyelerde piştikten sonra domatesli şehriye çorbası servise hazır. Afiyet olsun"
            )
        )
        arrayMeal.add(
            Meal(
                "Yoğurt Çorbası", R.drawable.yogurt, "Yoğurt Çorbası Tarifi İçin Malzemeler\n" +
                        " 7 su bardağı su\n" +
                        " 4 çorba kaşığı pirinç\n" +
                        " 1 çorba kaşığı un\n" +
                        " 1 yumurta sarısı\n" +
                        " 1 su bardağı yoğurt\n" +
                        " 2 çay kaşığı tuz\n" +
                        " Kuru nane\n\n" +
                        "Yoğurt çorbası yapımı için, tencereye suyu ekleyin, kaynadıktan sonra pirinçleri ekleyin.\n" +
                        "Bir kapta yumurta, un ve yoğurdu karıştırın.\n" +
                        "Pişen pirincin üzerine ekleyin ve karıştırın.\n" +
                        "Pişerken bir tutam kuru nane ekleyin.\n" +
                        "10 dakikaya yakın pişirdikten sonra yoğurt çorbasının altını kapatın ve tuzunu ekleyin.\n" +
                        "Yoğurt çorbası servise hazır. Afiyet olsun."
            )
        )

    }

    private fun setupMainCourseData() {
        arrayMainCourse.add(
            Meal(
                "Spagetti Bolonez",
                R.drawable.bolonez,
                "Spagetti için:\n" +
                        "1\n" +
                        "paket\n" +
                        "spagetti makarna\n" +
                        "1\n" +
                        "litre\n" +
                        "su\n" +
                        "1\n" +
                        "tatlı kaşığı\n" +
                        "tuz\n" +
                        "1\n" +
                        "yemek kaşığı\n" +
                        "zeytinyağı\n" +
                        "Bolonez Sos için:\n" +
                        "250\n" +
                        "gram\n" +
                        "kıyma\n" +
                        "1\n" +
                        "adet orta boy\n" +
                        "soğan\n" +
                        "1\n" +
                        "adet orta boy\n" +
                        "havuç\n" +
                        "1\n" +
                        "adet orta boy\n" +
                        "domates\n" +
                        "2\n" +
                        "diş\n" +
                        "sarımsak\n" +
                        "3\n" +
                        "yemek kaşığı\n" +
                        "zeytinyağı\n" +
                        "1\n" +
                        "çay kaşığı\n" +
                        "tuz\n" +
                        "1\n" +
                        "çay kaşığı\n" +
                        "karabiber\n\nDerin bir tencereye sıcak su koyun. Üzerine biraz tuz serpin. Makarnaları ekleyip, yumuşayana kadar haşlayın.\n" +
                        " \n" +
                        "bolonez-soslu-spagetti1\n" +
                        "Diğer yandan 1 adet soğanı, 2 diş sarımsağı ince ince doğrayın. 3 adet domatesi küp küp doğrayın. Havucu da rendeleyin. Bir tavaya 3 yemek kaşığı zeytinyağ koyun. Üzerine 1 adet ince ince doğranmış soğan ve sarımsağı da ekleyin. 2-3 dakika kadar kavurun.\n" +
                        "bolonez-soslu-spagetti2\n" +
                        "Rendelenmiş havucu ve 250 gram kıymayı ekleyin.\n" +
                        "bolonez-soslu-spagetti3\n" +
                        "Sürekli karıştırarak, 5 dakika pişirin.\n" +
                        "bolonez-soslu-spagetti4\n" +
                        "Son olarak küp küp doğranmış domatesleri de koyun.\n" +
                        "bolonez-soslu-spagetti5\n" +
                        "Tuz ve karabiberi ve makarnanın haşlama suyundan yarım su bardağı ekleyerek 3-4 dakika pişirin.\n" +
                        "bolonez-soslu-spagetti6\n" +
                        "Daha sonra haşlanmış olan makarnanın suyunu süzün. Üzerine hazırladığınız bolonez soslu karışımı koyun.\n" +
                        "bolonez-soslu-spagetti7\n" +
                        "İyice karıştırın. Afiyet olsun.\n"
            )
        )
        arrayMainCourse.add(
            Meal(
                "Et sote", R.drawable.etsote, "Et Sote Yemeği Tarifi İçin Malzemeler\n" +
                        "5 yemek kaşığı sıvı yağ\n" +
                        "1 yemek kaşığı tereyağı\n" +
                        "1 adet soğan\n" +
                        "500g kuşbaşı et\n" +
                        "2 adet domates\n" +
                        "4 adet sivri biber\n" +
                        "Pul biber\n" +
                        "Karabiber\n" +
                        "Kekik\n" +
                        "Sıcak su (üzerini geçecek kadar)\n" +
                        "Tuz\n\n" +
                        "Tavaya sıvı yağ ve tereyağını alalım.\n" +
                        " Tereyağı eridikten sonra doğranmış soğanı ekleyerek kavuralım.\n" +
                        " Kuşbaşı doğranmış eti de ilave edelim.\n" +
                        " Tencerenin kapağını kapatalım ve ara ara karıştırarak etler suyunu salıp çekinceye kadar pişirelim.\n" +
                        " Doğranmış domates ve doğranmış sivribiberi ilave edelim.\n" +
                        " Tencerenin kapağını kapatıp domatesler suyunu salıncaya kadar pişirmeye devam edelim.\n" +
                        " Daha sonra pul biber, karabiber ve kekiği ekleyerek karıştıralım.\n" +
                        " Etlerin üzerini geçecek şekilde sıcak suyu ilave edip karıştıralım ve tencerenin kapağını tekrar kapatalım.\n" +
                        " Etimiz lokum gibi yumuşayıncaya kadar pişirelim.\n" +
                        " Son olarak tuzunu ayarlayıp karıştıralım.\n" +
                        " 5 dk daha pişirdikten sonra ocağı kapatalım. Et sote yemeğimiz servise hazır. Afiyet olsun :)"
            )
        )
        arrayMainCourse.add(
            Meal(
                "Izgara Tavuk", R.drawable.izgara, "1\n" +
                        "kilogram\n" +
                        "tavuk göğsü\n" +
                        "1\n" +
                        "yemek kaşığı\n" +
                        "salça\n" +
                        "2\n" +
                        "yemek kaşığı\n" +
                        "yoğurt\n" +
                        "1\n" +
                        "yemek kaşığı\n" +
                        "sıvı yağ\n" +
                        "1\n" +
                        "tatlı kaşığı\n" +
                        "pul biber\n" +
                        "1/2\n" +
                        "tatlı kaşığı\n" +
                        "kekik\n" +
                        "1\n" +
                        "çay kaşığı\n" +
                        "kimyon\n" +
                        "2\n" +
                        "tatlı kaşığı\n" +
                        "tuz\n\n" +
                        "Tavuklar ince kesilir. Salça, yoğurt, sıvı yağ ve baharatlar karıştırılır. Tavuklar içine koyulup marine edilir.\n" +
                        "Dolapta 2 saat bekletilir. Tavuklar ızgaraya dizilir. Közde dilediğiniz ayarda pişirilir. Afiyet olsun."
            )
        )
        arrayMainCourse.add(
            Meal(
                "Mantar Sote", R.drawable.mantarsote, "Mantar Sote Tarifi İçin Malzemeler\n" +
                        "2 adet orta boy soğan\n" +
                        "3 adet yeşil biber\n" +
                        "3 diş sarımsak\n" +
                        "3 adet domates\n" +
                        "500g kültür mantarı\n" +
                        "3-4 yemek kaşığı sıvı yağ\n" +
                        "1 yemek kaşığı domates salçası\n" +
                        "1 çay kaşığı pul biber\n" +
                        "1 çay kaşığı tuz\n" +
                        "1 tutam maydanoz (isteğe bağlı)\n\n" +
                        "Mantar sote için öncelikle soğanları yemeklik olacak şekilde doğrayın.\n" +
                        "Yeşil biber ve sarımsakları da minik minik doğrayın.\n" +
                        "Domateslerin kabuklarını soyarak, onları da küp küp doğrayın.\n" +
                        "Mantarların kabuklarını soyarak onları da ince ince dilimleyelim.\n" +
                        "Tencereye bir miktar sıvı yağı  koyup doğranan soğan, biber ve sarımsakları 1-2 dakika kavurun.\n" +
                        "Ardından üzerine S-salça ve pul biberi ekleyerek 1-2 dakika daha kavurun.\n" +
                        "İnce ince dilimlenmiş mantarları ilave edip karıştırın. Mantarlar suyunu salıp çekinceye kadar pişirmeye devam edin.\n" +
                        "Karıştırılarak bir süre pişirildikten sonra doğranmış domatesleri ve tuzu ekleyerek yemek suyunu çekip, mantarlar yumuşayana  kadar pişirin.\n" +
                        "Mantar sotemiz servise hazır. Dilerseniz üzerine ince kıyılmış maydanoz serperek servis edebilirsiniz."
            )
        )
        arrayMainCourse.add(
            Meal(
                "Sebzeli Noodle", R.drawable.noodle, "Sebzeli Noodle Malzemeleri\n" +
                        "500 gr. yumurtalı noodle\n" +
                        "4 litre su\n" +
                        "1 adet havuç – ince uzun doğranmış\n" +
                        "½ adet kırmızı dolmalık biber – ince uzun doğranmış\n" +
                        "½ adet sarı dolmalık biber – ince uzun doğranmış\n" +
                        "1 adet yeşil dolmalık biber – ince uzun doğranmış\n" +
                        "1 kâse brokoli – çiçeklerine ayrılmış\n" +
                        "3-4 dal taze soğan – ince kıyılmış\n" +
                        "3 yemek kaşığı soya sos\n" +
                        "Zeytinyağı\n" +
                        "Tuz\n" +
                        "Karabiber\n\n" +
                        "Kaynayan tuzlu suda noodle’ları 10-12 dakika haşlayın. Noddle’larınız tamamen yumuşamasın biraz dişe gelir kıvamda kalması daha iyi bir sonuç almanızı sağlayacaktır. Sürenin sonunda noodle’larınızı süzün.\n" +
                        "\n" +
                        "Bir tavaya zeytinyağı ekleyin, sırasıyla havuç, brokoli, biberleri soteleyin. Sebzeleriniz biraz yumuşadığında haşlanmış olan noodle’ı sebzelere ekleyin harmanlayın, soya sos, tuz ve karabiberi de ekleyip karıştırın ve kenara alın.\n" +
                        "\n" +
                        "Kenara aldıktan sonra taze soğanı içerisine ekleyin son bir kes daha karıştırıp servis edin."
            )
        )
        arrayMainCourse.add(
            Meal(
                "Tavuk Şinitzel", R.drawable.sinitzel, "4\n" +
                        "adet\n" +
                        "fileto tavuk göğsü\n" +
                        "1\n" +
                        "çay kaşığı\n" +
                        "tuz\n" +
                        "1/2\n" +
                        "çay kaşığı\n" +
                        "taze çekilmiş tane karabiber\n" +
                        "Kaplaması için:\n" +
                        "5\n" +
                        "yemek kaşığı\n" +
                        "un\n" +
                        "2\n" +
                        "adet\n" +
                        "büyük boy yumurta\n" +
                        "1\n" +
                        "tatlı kaşığı\n" +
                        "hardal\n" +
                        "(opsiyonel)\n" +
                        "1,5\n" +
                        "su bardağı\n" +
                        "galeta unu\n" +
                        "Kızartmak için:\n" +
                        "1,5\n" +
                        "su bardağı\n" +
                        "ayçiçek yağı\n\n" +
                        "Fileto tavuk göğüslerini uzunlamasına ortadan ikiye kesin.\n" +
                        "Tavuk Şinitzel\n" +
                        "Yırtılmaması için üzerlerini streç film ile kapladığınız fileto parçalarını bir et döveceği ya da ağırlık yardımıyla inceltin.\n" +
                        "Tavuk Şinitzel\n" +
                        "Filetoların her iki yanını tuz ve karabiber ile lezzetlendirin.\n" +
                        "Tavuk Şinitzel\n" +
                        "Yumurtaları hardalla birlikte geniş bir kasede çırpın.\n" +
                        "tavuk-sinitzel\n" +
                        "Un ve galeta ununu düz bir tabağa yayın. İncelttiğiniz fileto tavuk dilimlerinin her iki tarafını öncelikle una bulayın. Fazla unlarını temizleyin.\n" +
                        "tavuk-sinitzel\n" +
                        "Sonrasında her iki tarafını çırpılmış yumurtaya bulayın.\n" +
                        "Tavuk Şinitzel\n" +
                        "Son olarak her yerini galeta unuyla kaplayın.\n" +
                        "tavuk-sinitzel\n" +
                        "Bir kızartma tavasına ayçiçek yağını ekleyin ve kızdırın. Sonrasında filetoları ekleyerek her iki yanını da yaklaşık 4-5 dakika kadar kızartın.\n" +
                        "Tavuk Şinitzel\n" +
                        "Fazla yağını bırakması için kağıt havlu serili bir servis tabağına alıp, 1-2 dakika kadar dinlendirdiğiniz tavuk şinitzelleri dilediğiniz gibi servis edin. Afiyetler olsun!\n" +
                        "Tavuk Şinitzel"
            )
        )
        arrayMainCourse.add(
            Meal(
                "Fırında Somon", R.drawable.somon, "2\n" +
                        "dilim\n" +
                        "somon\n" +
                        "1\n" +
                        "çorba kaşığı\n" +
                        "zeytinyağı\n" +
                        "1/2\n" +
                        "adet\n" +
                        "portakal suyu\n" +
                        "10-15\n" +
                        "adet\n" +
                        "tane karabiber\n" +
                        "1\n" +
                        "çay kaşığı\n" +
                        "iri çekilmiş deniz tuzu\n" +
                        "1-2\n" +
                        "dal\n" +
                        "taze kekik (arzuya göre)\n" +
                        "(veya biberiye)\n\n" +
                        "Somonları geniş bir kaba alıp, zeytinyağını somona iyice yedirin.\n" +
                        "Tavayı ocağa alın ve ısıtın.\n" +
                        "Zeytinyağı ile yağladığınız somona, portakal suyu, karabiber ve deniz tuzunu ekleyin.\n" +
                        "Isınan tavayı bir parça zeytinyağı ile peçete yardımı yağlayın.\n" +
                        "Somonun her iki yüzeyini de 5'er dakika pişirin. Biberiye veya taze kekik ile servis edin, işte bu kadar, afiyet olsun!"
            )
        )


    }

    private fun setupSideDishData() {
        arraySideDish.add(
            Meal(
                "CheesCake",
                R.drawable.cheescake,
                "Limonlu Cheesecake Nasıl Yapılır? İçin Malzemeler\n" +
                        "Tabanı için;\n" +
                        "\n" +
                        "100 gr yulaflı bisküvi\n" +
                        "50 gr tereyağı\n" +
                        "Yarım su bardağı fındık\n" +
                        "Kreması için;\n" +
                        "\n" +
                        "2 paket labne peyniri (400 gr)\n" +
                        "1 su bardağı toz şeker\n" +
                        "1 paket vanilya\n" +
                        "2 adet yumurta\n" +
                        "1 paket krema (200 ml)\n" +
                        "3 yemek kaşığı un\n" +
                        "1 adet limon kabuğu rendesi\n" +
                        "Limon sosu için;\n" +
                        "\n" +
                        "1 su bardağı su\n" +
                        "1 yemek kaşığı nişasta\n" +
                        "5 yemek kaşığı toz şeker\n" +
                        "1 adet limon suyu\n" +
                        "1 adet limon kabuğu rendesi\n" +
                        "Çay kaşığının ucuyla zerdeçal\n\n" +
                        "Limonlu cheesecakekin tabanı için öncelikle bisküvileri ve fındığı robottan un gibi olana kadar geçirelim.\n" +
                        "Fındıklı bisküvileri bir kaba alalım, üzerine eritilmiş tereyağını ekleyerek karıştıralım.\n" +
                        "Kelepçeli kabın tabanına pişirme kağıdı yerleştirelim, makas yardımı ile fazlasını keselim. Ben bu tarifte 20 cm çapında yuvarlak kalıp kullandım.\n" +
                        "Kalıbın tabanına kum haline getirdiğimiz bisküvilerimizi yerleştirip kaşıkla bastırarak yerleştirelim.\n" +
                        "Kreması için karıştırma kabına labne peyniri alalım ve mikserle çırpalım.\n" +
                        "Sıvı kremayı da ekleyerek çırpmaya devam edelim.\n" +
                        "Sonrasında toz şeker, yumurta, un, vanilya ve limon kabuğu rendesini ekleyerek tüm malzemeler karışıncaya kadar güzelce çırpalım.\n" +
                        "Hazırladığımız kremayı bisküvilerin üzerine yerleştirip önceden ısıttığımız 160°C fırında alt üst fansız ayarda 1 saat kadar pişmeye bırakalım. Pişerken çatlamaması için cheesecakekimizin yanına ısıya dayanıklı bir kapla su koyalım. Piştikten sonra fırının kapağını yarım olacak şekilde açalım da 1 saat bu şekilde dinlenmeye bırakalım.\n" +
                        "Limon sosu için tencereye su, şeker, nişasta ve limon suyunu ekleyerek çırpalım.\n" +
                        "Malzemeler karıştıktan sonra renk vermesi için zerdeçal ekleyelim ve karıştıralım. Zerdeçal herhangi bir tat vermeyecek yalnızca renginin daha güzel olmasını sağlayacaktır. Dilerseniz kullanmadan da hazırlayabilirsiniz.\n" +
                        "Limon kabuğunu da ekleyip karıştırdıktan sonra sosumuzu pişmeye bırakalım. Cheesecakekinizi limonlu sosla yapabileceğiniz gibi farklı soslarla da hazırlayabilirsiniz.\n" +
                        "Koyulaşan limonlu sosumuzun altını kapattıktan sonra soğumaya bırakalım. Bu aşamada üzerinin kabuklanmaması için ara ara karıştıralım.\n" +
                        "Soğuyan sosumuzu tatlımızın üzerine gezdirelim ve 1 gece dinlenmeye bırakalım. Eğer vaktiniz yoksa bir kaç saatte dinlendirebilirsiniz.\n" +
                        "Dinlenen tatlımızı kalıptan çıkartıp üzerini süsledikten sonra dilimleyerek servis edelim."
            )
        )
        arraySideDish.add(
            Meal(
                "Çikolatalı Sufle",
                R.drawable.ciksufle,
                "Çikolatalı Sufle Tarifi İçin Malzemeler\n" +
                        "125\n" +
                        "gram\n" +
                        "bitter çikolata\n" +
                        "125\n" +
                        "mililitre\n" +
                        "süt\n" +
                        "(1 çay bardağı)\n" +
                        "3\n" +
                        "adet\n" +
                        "yumurta\n" +
                        "(sarıları ve beyazları ayrılmış)\n" +
                        "2\n" +
                        "yemek kaşığı\n" +
                        "tereyağı\n" +
                        "1,5\n" +
                        "yemek kaşığı\n" +
                        "un\n" +
                        "1/4\n" +
                        "çay kaşığı\n" +
                        "tuz\n" +
                        "2\n" +
                        "yemek kaşığı\n" +
                        "toz şeker\n" +
                        "Pişirme Kaplarını Yağlamak İçin:\n" +
                        "1\n" +
                        "yemek kaşığı\n" +
                        "tereyağı\n" +
                        "1\n" +
                        "yemek kaşığı\n" +
                        "kakao\n" +
                        "Servisi İçin:\n" +
                        "1\n" +
                        "yemek kaşığı\n" +
                        "pudra şekeri\n\n" +
                        "125 mililitre sütü bir sos tenceresine alın ve kaynama noktasına gelinceye kadar ısıtın.\n" +
                        "sufle1\n" +
                        "İçerisine çikolatayı ilave edin. Çikolata eridikten sonra ocaktan alın.\n" +
                        "sufle2\n" +
                        "Ayrı bir sos tenceresinde 2 yemek kaşığı tereyağını eritin.\n" +
                        "sufle3\n" +
                        "Üzerine 1,5 yemek kaşığı unu ilave ederek, kokusu çıkana kadar kavurun.\n" +
                        "sufle4\n" +
                        "Unun kokusu çıktıktan sonra çikolatalı süt karışımının içerisine ilave edin ve 2 yemek kaşığı toz şekeri ilave ederek sürekli olarak karıştırın.\n" +
                        "sufle6\n" +
                        "3 adet yumurta sarılarını da ilave edin, 2 dakika daha karıştırdıktan sonra ocaktan alın ve soğumaya bırakın.\n" +
                        "sufle9\n" +
                        "Derin bir kasede 3 adet yumurta beyazlarını bir çimdik tuz ile birlikte kaseyi ters çevirdiğinizde akmayacak kıvama gelinceye kadar çırpın.\n" +
                        "sufle12\n" +
                        "Soğumuş olan çikolatalı karışım ile köpük haline gelmiş yumurta aklarını birleştirin ve spatula yardımıyla karıştırın.\n" +
                        "sufle14\n" +
                        "Yağlanmış ve kakao ile kaplanmış sufle kaplarına bir parmak boşluk kalacak şekilde harcı bölüştürün ve önceden ısıtılmış 200 derece fırında 10 dakika pişirin.\n" +
                        "sufle19\n" +
                        "Fırından çıkar çıkmaz üzerine pudra şekeri serpiştirip servis edin, afiyet olsun!"
            )
        )
        arraySideDish.add(
            Meal(
                "Muhallebi", R.drawable.muhallebi, "Muhallebi Tarifi İçin Malzemeler\n" +
                        "5\n" +
                        "su bardağı\n" +
                        "süt\n" +
                        "1\n" +
                        "su bardağı\n" +
                        "toz şeker\n" +
                        "3\n" +
                        "yemek kaşığı\n" +
                        "buğday nişastası\n" +
                        "(elenmiş)\n" +
                        "1\n" +
                        "paket\n" +
                        "vanilin\n" +
                        "1/2\n" +
                        "çay bardağı\n" +
                        "un\n" +
                        "(elenmiş)\n" +
                        "1\n" +
                        "tatlı kaşığı\n" +
                        "tereyağı\n" +
                        "Servisi için:\n" +
                        "1\n" +
                        "adet\n" +
                        "muz\n" +
                        "1\n" +
                        "yemek kaşığı\n" +
                        "toz Antep fıstığı\n\n" +
                        "5 su bardağı soğuk sütü geniş bir tencereye aktarın. Yarım çay bardağı un, 3 yemek kaşığı buğday nişastası ve 1 su bardağı toz şekeri ilave ettikten sonra ocağın altını açın.\n" +
                        "muhallebi-1\n" +
                        "Ara ara karıştırarak koyu bir kıvam alana kadar pişirin.\n" +
                        "muhallebi-2\n" +
                        "Kıvam alan muhallebinin altını kapatın.\n" +
                        "muhallebi-3\n" +
                        "Henüz sıcakken içerisine 1 tatlı kaşığı tereyağı ve 1 paket vanilin ilave ederek çırpın.\n" +
                        "muhallebi-4\n" +
                        "Ardından servis kaselerine paylaştırın ve soğutun.\n" +
                        "muhallebi-6\n" +
                        "Antep fıstığıyla süsleyip tatlandırdığınız muhallebileri soğuk olarak sevdiklerinizle paylaşın."
            )
        )
        arraySideDish.add(
            Meal(
                "Panna Cotta",
                R.drawable.pannacotta,
                "Böğürtlen Soslu Panna Cotta Tarifi İçin Malzemeler\n" +
                        "250\n" +
                        "ml.\n" +
                        "krema\n" +
                        "250\n" +
                        "ml.\n" +
                        "soğuk süt\n" +
                        "1\n" +
                        "paket\n" +
                        "vanilya\n" +
                        "(ya da vanilya çubuğu)\n" +
                        "3\n" +
                        "yemek kaşığı\n" +
                        "toz şeker\n" +
                        "3\n" +
                        "yaprak\n" +
                        "jelatin\n" +
                        "Böğürtlen Sosu İçin:\n" +
                        "1\n" +
                        "su bardağı\n" +
                        "böğürtlen\n" +
                        "5\n" +
                        "yemek kaşığı\n" +
                        "şeker\n" +
                        "1\n" +
                        "tatlı kaşığı\n" +
                        "buğday nişastası\n" +
                        "1/2\n" +
                        "su bardağı\n" +
                        "su\n\n" +
                        "Tatlıya kıvamını verecek olan yaprak jelatinleri, kendiliğinden yumuşaması için soğuk su dolu bir kasede 5 dakika kadar bekletin.\n" +
                        "bogurtlen-soslu-panna-cotta\n" +
                        "Krema, süt, toz şeker ve vanilyayı küçük bir tencereye aktarın ve kısık ateşte kaynama derecesine gelene dek pişirin.\n" +
                        "bogurtlen-soslu-panna-cotta\n" +
                        "Soğuk suda yumuşayan yaprak jelatinlerin suyunu sıkın.\n" +
                        "bogurtlen-soslu-panna-cotta\n" +
                        "Jelatinleri ocaktan aldığınız tatlı karışımına katın. Karıştırarak jelatinlerin erimelerini sağlayın.\n" +
                        "bogurtlen-soslu-panna-cotta\n" +
                        "Tatlıyı ikram etmenizde kolaylık sağlayacak silikon ya da tek kullanımlık kapları ıslatın. Fazla sularını süzdürün. Karışımı porsiyonluk kalıplara eşit olarak paylaştırın. Kıvam alması için buzdolabında en az 2 saat kadar bekletin.\n" +
                        "bogurtlen-soslu-panna-cotta\n" +
                        "Tatlının sosu için; böğürtlenleri, suyu ve şekeri küçük bir tencereye alıp orta ateşte 5 dakika kaynatarak pişirin.\n" +
                        "bogurtlen-soslu-panna-cotta\n" +
                        "Karışımı süzün.\n" +
                        "bogurtlen-soslu-panna-cotta\n" +
                        "Nişastayı 2 yemek kaşığı soğuk su ile karıştırın. Küçük bir tencerede süzdüğünüz böğürtlen sosuna ekleyerek kısık ateşte pişirin. Hafif koyulaşan sosu ocaktan alın ve soğumaya bırakın.\n" +
                        "bogurtlen-soslu-panna-cotta\n" +
                        "Soğuyup, kıvam alan tatlıları servis tabaklarına ters çevirerek çıkartın. Hazırladığınız böğürtlen sos ve arzuya göre ekleyeceğiniz meyveler eşliğinde bekletmeden servis edin. Sevdiklerinizle paylaşın"
            )
        )
        arraySideDish.add(
            Meal(
                "Profiteröl", R.drawable.profiterol, "8-10 Kişilik 20dk Hazırlık, 45dk Pişirme \n" +
                        "Profiterol Tarifi İçin Malzemeler\n" +
                        " 1 su bardağı su\n" +
                        " 1 su bardağı un\n" +
                        " 125 gr tereyağı veya margarin\n" +
                        " 3 adet yumurta (yumurtalar küçük ise 4 adet)\n" +
                        "Profiterol Kreması için;\n" +
                        "\n" +
                        " 2,5 su bardağı süt\n" +
                        " 3 yemek kaşığı un\n" +
                        " 1,5 çay bardağı şeker\n" +
                        " 1 adet yumurta\n" +
                        " 1 paket vanilya\n" +
                        "Üzeri İçin\n" +
                        "\n" +
                        " 1 paket hazır çikolata sosu ya da benmari usulü eritilmiş 80 gr bitter çikolata\n\n" +
                        " İlk olarak profiterolün hamurunu hazırlayalım. Küçük bir tencereye 1 su bardağı suyu ve margarini koyarak kaynatın. Daha sonra 1 su bardağı unu ekleyerek iyice karıştırın. 2-3 dakika karışımı sürekli karıştırarak pişirin. Ocağı kapatarak 10-15 dakika hamurun soğumasını bekleyin. Hamur biraz dinlendikten sonra 3 adet yumurtayı hamura yedirmemiz gerekiyor ancak bu noktada önemli bir ayrıntı var. Yumurtaları teker teker hamura kırın ve birini iyice yedirmeden diğer yumurtayı kırmayın. Yumurtaları hamura iyice yedirdikten sonra yapışkan bir hamur elde etmiş olduk. Bu kısım biraz yorucu oluyor ama hamurun kabarması için iyice karıştırmış olmanız gerekiyor. Yumurtaları yedirdikten sonra hamuru 10 dakika dinlendirin.\n" +
                        " Hamurlarımızı pişirelim. Yağlanmış tepsiye, kaşık yardımı ile hamurdan ceviz büyüklüğünde parçalar alarak aralarında 2-3 cm boşluk bulunmasına dikkat ederek resimdeki gibi dökün. Elinizle şekillendirmeye çalışmayın. Daha önceden 180 derecede ısıttığımız fırına hamuru sürün. üzeri kızarana kadar yaklaşık 40 dakika pişiriyorsunuz.\n" +
                        "Profiterol Kremasını hazırlayalım. Hamurlar piştikten sonra kremasını hazırlayın. Vanilya hariç diğer malzemeleri bir tencereye koyarak kremayı pişirin. Kremayı ocaktan aldıktan sonra vanilyasını ekleyerek karıştırın.\n" +
                        "Kremayı profiterol hamurlarına dolduralım. Profiterolün  pişen hamurlarını ikiye bölerek ya da varsa krema sıkma torbası ile içlerini krema ile doldurun ve tepsiye dizin.\n" +
                        "Tatlımızın üzerine çikolata sosu gezdirelim. Tüm profiterolleri doldurduktan sonra üzerine çikolata sosunu ya da benmari usulü erittiğiniz çikolatayı gezdirin.\n" +
                        "Afiyet olsun.."
            )
        )
        arraySideDish.add(
            Meal(
                "Tiramisu", R.drawable.tiramisu, "Malzemeler:\n" +
                        "Tabanı için:\n" +
                        "–4 yumurta\n" +
                        "–1 su bardağı şeker\n" +
                        "–1,5 su bardağı un\n" +
                        "–1 paket kabartma tozu\n" +
                        "–1 paket vanilya\n" +
                        "\n" +
                        "Tabanı Islatmak için:\n" +
                        "– 1 su bardağı sıcak su\n" +
                        "–1 yemek kaşığı granül kahve\n" +
                        "–2 yemek kaşığı şeker\n" +
                        "\n" +
                        "Krema için:\n" +
                        "–300 g Pınar Labne\n" +
                        "–1 litre süt\n" +
                        "–1 su bardağı un\n" +
                        "–6 yemek kaşığı şeker\n" +
                        "–1 yumurta sarısı\n" +
                        "–1 paket vanilya\n" +
                        "\n" +
                        "Üzeri için:\n" +
                        "–Kakao\n" +
                        "\n" +
                        "Yapılışı:\n" +
                        "4 yumurta ve bir su bardağı şekeri derin bir kapta köpük köpük oluncaya kadar çırpın. Ardından unu, kabartma tozunu ve vanilyayı ekleyin ve tekrar çırpın. 24 santimlik kare kalıba karışımı dökerek 160 derecede önceden ısıtılmış fırında pişmeye bırakın. 1 litre süte unu, şekeri ve yumurta sarısını ekleyin, kısık ateşte çırparak koyulaşana kadar pişirin. Piştikten sonra ocaktan alıp biraz ılınmasını bekleyin. Daha sonra muhallebiye Pınar Labne'yi ve vanilyayı ekleyin ve çırpın. Pişen keki iki parçaya kesin. Kestiğiniz kekin tabanını su, kahve ve şekerle hazırladığınız karışımla ıslatın. Kremanın yarısını kalıba boşaltıp yayın. Kekin diğer yarısını kalıba yerleştirip tekrar su, kahve ve şeker karışımıyla ıslatın. Kalan kremayı da üzerine boşaltın. Son olarak üzerine kakao serpin. 1 gece dinlendirdikten sonra servis edebilirsiniz. Afiyet olsun!"
            )
        )
        arraySideDish.add(
            Meal(
                "İrmik Helvası", R.drawable.irmikhelva, "İrmik Helvası Tarifi İçin Malzemeler\n" +
                        "Helva için:\n" +
                        "3\n" +
                        "yemek kaşığı\n" +
                        "tereyağı\n" +
                        "1/2\n" +
                        "su bardağı\n" +
                        "çam fıstığı\n" +
                        "1,5\n" +
                        "su bardağı\n" +
                        "irmik\n" +
                        "1,5\n" +
                        "su bardağı\n" +
                        "süt\n" +
                        "1,5\n" +
                        "su bardağı\n" +
                        "su\n" +
                        "1,5\n" +
                        "su bardağı\n" +
                        "toz şeker\n" +
                        "Servisi için:\n" +
                        "2\n" +
                        "tatlı kaşığı\n" +
                        "tarçın (arzuya göre)\n\n" +
                        "3 yemek kaşığı tereyağını tavada eritin.\n" +
                        "irmik-helvasi-adim-1\n" +
                        "Yarım su bardağı çam fıstığını içine atarak kavurmaya başlayın.\n" +
                        "irmik-helvasi-adim-2\n" +
                        "Fıstıklar kavrulduktan sonra 1,5 su bardağı irmiği tencereye aktarın.\n" +
                        "irmik-helvasi-adim-3\n" +
                        "Sürekli karıştırıp, kısık ateşte 20 dakika kadar kavurun.\n" +
                        "irmik-helvasi-adim-4\n" +
                        "Tatlının şerbeti için; 1,5 su bardağı su, 1,5 su bardağı şeker ve 1,5 su bardağı sütü küçük bir sos tenceresine alın. Karıştırdıktan sonra kısık ateşte kaynamaya bırakın.\n" +
                        "irmik-helvasi-adim-5\n" +
                        "İrmik iyice kavrulduktan sonra sıcak şerbet karışımını, tavaya azar azar aktarın.\n" +
                        "irmik-helvasi-adim-6\n" +
                        "Sıcak şerbetin etkisiyle fokur fokur kaynamaya başlayan irmik sürekli olarak karıştırmaya devam edin.\n" +
                        "irmik-helvasi-adim-7\n" +
                        "Helvayı kısık ateşte 8-10 dakika kadar pişirmeye devam edin. Dinlenmesi için üzerine bir kapak kapatın.\n" +
                        "irmik-helvasi-adim-8\n" +
                        "Demlenen irmik helvasını servis kaselerine alıp, ters çevirip çıkardıktan sonra arzuya göre tarçın ilavesiyle birlikte dondurma ile servis edin. Afiyet olsun!\n" +
                        "irmik-helvasi-adim-9"
            )
        )
        // Diğer yan yemek öğelerini buraya ekle...
    }
}
