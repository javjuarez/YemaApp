package com.example.yemaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.example.yemaapp.adapter.ProductorAdapter
import com.example.yemaapp.database.DBProductores
import com.example.yemaapp.databinding.ActivityMainBinding
import com.example.yemaapp.models.Productor
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listProductores: ArrayList<Productor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val dbProductor = DBProductores(this)

//        Dummy data
//        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
//        val arrayInsert = listOf<List<String>>(
//            listOf ("Meridith", "Billson", "mbillson0@prlog.org", "889-224-4252", "F", "2021-08-07", "Crona Group"),
//            listOf ("Morgun", "Belone", "mbelone1@youtube.com", "117-395-2232", "M", "2021-05-01", "Buckridge and Sons"),
//            listOf ("Trenna", "Tolliday", "ttolliday2@istockphoto.com", "859-309-9008", "F", "2022-02-19", "Klein-Dickens"),
//            listOf ("Noellyn", "Blofeld", "nblofeld3@gnu.org", "523-996-2877", "F", "2021-05-31", "Becker, Steuber and Harvey"),
//            listOf ("Wenona", "Scud", "wscud4@seesaa.net", "646-429-5635", "F", "2021-10-13", "Leuschke Group"),
//            listOf ("Enrica", "Jenton", "ejenton5@jalbum.net", "290-401-8379", "F", "2021-08-25", "Howe and Sons"),
//            listOf ("Ernestus", "Tomasello", "etomasello6@histats.com", "926-758-8776", "M", "2022-01-15", "O'Hara,  Doyle and Konopelski"),
//            listOf ("Trev", "Antoniou", "tantoniou7@sciencedaily.com", "323-561-7108", "M", "2021-05-22", "Koepp-O'Conner"),
//            listOf ("Abeu", "Walsh", "awalsh8@about.com", "170-136-7385", "M", "2022-04-02", "Stroman,  Weber and Kertzmann"),
//            listOf ("Klaus", "Fears", "kfears9@ucoz.ru", "916-209-8236", "M", "2020-12-04", "Kreiger,  Collins and Bayer"),
//            listOf ("Georas", "Whapples", "gwhapplesa@xing.com", "543-855-6318", "M", "2021-04-25", "Padberg-Hodkiewicz"),
//            listOf ("Josselyn", "Babonau", "jbabonaub@constantcontact.com", "443-582-4661", "F", "2021-08-19", "Leuschke and Sons"),
//            listOf ("Patience", "Meneux", "pmeneuxc@ebay.com", "209-256-3638", "F", "2020-11-19", "Orn and Sons"),
//            listOf ("Christiane", "McDool", "cmcdoold@tamu.edu", "314-420-2226", "F", "2020-11-27", "Mohr-Maggio"),
//            listOf ("Silvia", "Drydale", "sdrydalee@behance.net", "100-925-3045", "F", "2021-11-29", "Spinka-Kiehn"),
//            listOf ("Theodora", "Mieville", "tmievillef@nyu.edu", "306-811-8041", "F", "2021-03-16", "Konopelski Inc"),
//            listOf ("Ediva", "Gillyatt", "egillyattg@tripod.com", "491-518-1547", "F", "2020-11-21", "Bauch Group"),
//            listOf ("Laureen", "Savin", "lsavinh@sbwire.com", "681-506-0359", "F", "2021-12-30", "Johns LLC"),
//            listOf ("Bartel", "Fanti", "bfantii@miitbeian.gov.cn", "510-243-4293", "M", "2021-10-30", "Bartoletti, Conn and Orn"),
//            listOf ("Mariya", "Thurber", "mthurberj@parallels.com", "513-880-2940", "F", "2021-09-26", "Cartwright Group")
//        )
//
//        for (arr in arrayInsert) {
//            dbProductor.insertProductores(arr[0], arr[1], arr[2], arr[3], arr[4], simpleDateFormat.parse(arr[5]) as Date, arr[6])
//        }

        // Se obtienen los productores de la DB
        listProductores = dbProductor.getProductores()
//        var prodTmp: Productor
//        for (i in 1 until 10) {
//            prodTmp = Productor(
//                i, "Nombre muymuylargomuymuylargomuymuylargomuymuylargomuymuylargo $i", "Apellidos $i", "email$i@test.com",
//                "$i$i$i$i$i$i$i$i", "M", Date(), "Exp $i"
//            )
//            listProductores.add(prodTmp)
//        }

        val productorAdapter = ProductorAdapter(this, listProductores)

        with(binding) {
            setContentView(root)
            setSupportActionBar(appToolbar.appToolbar)

            gridViewProductores.adapter = productorAdapter
            gridViewProductores.setOnItemClickListener { _, _, _, l ->
                startActivity(Intent(this@MainActivity, DatosProductorSeleccionado::class.java)
                    .putExtra("ID", l.toInt()))
                finish()
            }

            appToolbar.appToolbar.setNavigationOnClickListener {
                startActivity(Intent(this@MainActivity, DatosUsuario::class.java))
                finish()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    fun click(view: View) {
        startActivity(Intent(this@MainActivity, DatosProductorSeleccionado::class.java))
        finish()
    }
}