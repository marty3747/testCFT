package com.demo.testcft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }

        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.textViewShowValute);
        DownloadValuteTask task = new DownloadValuteTask();
        task.execute("https://www.cbr-xml-daily.ru/daily_json.js");
    }

    private class DownloadValuteTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            HttpURLConnection urlConnection = null;
            StringBuilder result = new StringBuilder();
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    result.append(line);
                    line = reader.readLine();
                }
                return result.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONObject valute = jsonObject.getJSONObject("Valute");

                String aud = valute.getString("AUD");
                String aud1 = aud.substring(43,46);
                int valuteAudStart = aud.indexOf(":", 70);
                int valuteAudEnds = aud.indexOf(",\"Previous\"");
                String valuteAud = aud.substring(valuteAudStart + 1, valuteAudEnds);

                String azn = valute.getString("AZN");
                String azn1 = azn.substring(44,47);
                int valuteAznStart = azn.indexOf(":", 70);
                int valuteAznEnds = azn.indexOf(",\"Previous\"");
                String valuteAzn = azn.substring(valuteAznStart + 1, valuteAznEnds);

                String gbp = valute.getString("GBP");
                String gbp1 = gbp.substring(43,46);
                int valuteGbpStart = gbp.indexOf(":", 70);
                int valuteGbpEnds = gbp.indexOf(",\"Previous\"");
                String valuteGbp = gbp.substring(valuteGbpStart + 1, valuteGbpEnds);

                String amd = valute.getString("AMD");
                String amd1 = amd.substring(43,46);
                int valuteAmdStart = amd.indexOf(":", 70);
                int valuteAmdEnds = amd.indexOf(",\"Previous\"");
                String valuteAmd = amd.substring(valuteAmdStart + 1, valuteAmdEnds);

                String byn = valute.getString("BYN");
                String byn1 = byn.substring(44,47);
                int valuteBynStart = byn.indexOf(":", 70);
                int valuteBynEnds = byn.indexOf(",\"Previous\"");
                String valuteByn = byn.substring(valuteBynStart + 1, valuteBynEnds);

                String bgn = valute.getString("BGN");
                String bgn1 = bgn.substring(43,46);
                int valuteBgnStart = bgn.indexOf(":", 70);
                int valuteBgnEnds = bgn.indexOf(",\"Previous\"");
                String valuteBgn = bgn.substring(valuteBgnStart + 1, valuteBgnEnds);

                String brl = valute.getString("BRL");
                String brl1 = brl.substring(43,46);
                int valuteBrlStart = brl.indexOf(":", 70);
                int valuteBrlEnds = brl.indexOf(",\"Previous\"");
                String valuteBrl = brl.substring(valuteBrlStart + 1, valuteBrlEnds);

                String huf = valute.getString("HUF");
                String huf1 = huf.substring(43,46);
                int valuteHufStart = huf.indexOf(":", 70);
                int valuteHufEnds = huf.indexOf(",\"Previous\"");
                String valuteHuf = huf.substring(valuteHufStart + 1, valuteHufEnds);

                String hkd = valute.getString("HKD");
                String hkd1 = hkd.substring(43,46);
                int valuteHkdStart = hkd.indexOf(":", 70);
                int valuteHkdEnds = hkd.indexOf(",\"Previous\"");
                String valuteHkd = hkd.substring(valuteHkdStart + 1, valuteHkdEnds);

                String dkk = valute.getString("DKK");
                String dkk1 = dkk.substring(43,46);
                int valuteDkkStart = dkk.indexOf(":", 70);
                int valuteDkkEnds = dkk.indexOf(",\"Previous\"");
                String valuteDkk = dkk.substring(valuteDkkStart + 1, valuteDkkEnds);

                String usd = valute.getString("USD");
                String usd1 = usd.substring(43,46);
                int valuteUsdStart = usd.indexOf(":", 70);
                int valuteUsdEnds = usd.indexOf(",\"Previous\"");
                String valuteUsd = usd.substring(valuteUsdStart + 1, valuteUsdEnds);

                String eur = valute.getString("EUR");
                String eur1 = eur.substring(43,46);
                int valuteEurStart = eur.indexOf(":", 70);
                int valuteEurEnds = eur.indexOf(",\"Previous\"");
                String valuteEur = eur.substring(valuteEurStart + 1, valuteEurEnds);

                String inr = valute.getString("INR");
                String inr1 = inr.substring(43,46);
                int valuteInrStart = inr.indexOf(":", 70);
                int valuteInrEnds = inr.indexOf(",\"Previous\"");
                String valuteInr = inr.substring(valuteInrStart + 1, valuteInrEnds);

                String kzt = valute.getString("KZT");
                String kzt1 = kzt.substring(43,46);
                int valuteKztStart = kzt.indexOf(":", 70);
                int valuteKztEnds = kzt.indexOf(",\"Previous\"");
                String valuteKzt = kzt.substring(valuteKztStart + 1, valuteKztEnds);

                String cad = valute.getString("CAD");
                String cad1 = cad.substring(43,46);
                int valuteCadStart = cad.indexOf(":", 70);
                int valuteCadEnds = cad.indexOf(",\"Previous\"");
                String valuteCad = cad.substring(valuteCadStart + 1, valuteCadEnds);

                String kgs = valute.getString("KGS");
                String kgs1 = kgs.substring(43,46);
                int valuteKgsStart = kgs.indexOf(":", 70);
                int valuteKgsEnds = kgs.indexOf(",\"Previous\"");
                String valuteKgs = kgs.substring(valuteKgsStart + 1, valuteKgsEnds);

                String cny = valute.getString("CNY");
                String cny1 = cny.substring(43,46);
                int valuteCynStart = cny.indexOf(":", 70);
                int valuteCynEnds = cny.indexOf(",\"Previous\"");
                String valuteCny = cny.substring(valuteCynStart + 1, valuteCynEnds);

                String mdl = valute.getString("MDL");
                String mdl1 = mdl.substring(43,46);
                int valuteMdlStart = mdl.indexOf(":", 70);
                int valuteMdlEnds = mdl.indexOf(",\"Previous\"");
                String valuteMdl = mdl.substring(valuteMdlStart + 1, valuteMdlEnds);

                String nok = valute.getString("NOK");
                String nok1 = nok.substring(43,46);
                int valuteNokStart = nok.indexOf(":", 70);
                int valuteNokEnds = nok.indexOf(",\"Previous\"");
                String valuteNok = nok.substring(valuteNokStart + 1, valuteNokEnds);

                String pln = valute.getString("PLN");
                String pln1 = pln.substring(43,46);
                int valutePlnStart = pln.indexOf(":", 70);
                int valutePlnEnds = pln.indexOf(",\"Previous\"");
                String valutePln = pln.substring(valutePlnStart + 1, valutePlnEnds);

                String ron = valute.getString("RON");
                String ron1 = ron.substring(44,47);
                int valuteRonStart = ron.indexOf(":", 70);
                int valuteRonEnds = ron.indexOf(",\"Previous\"");
                String valuteRon = ron.substring(valuteRonStart + 1, valuteRonEnds);

                String xdr = valute.getString("XDR");
                String xdr1 = xdr.substring(43,46);
                int valuteXdrStart = xdr.indexOf(":", 70);
                int valuteXdrEnds = xdr.indexOf(",\"Previous\"");
                String valuteXdr = xdr.substring(valuteXdrStart + 1, valuteXdrEnds);

                String sgd = valute.getString("SGD");
                String sgd1 = sgd.substring(43,46);
                int valuteSgdStart = sgd.indexOf(":", 70);
                int valuteSgdEnds = sgd.indexOf(",\"Previous\"");
                String valuteSgd = sgd.substring(valuteSgdStart + 1, valuteSgdEnds);

                String tjs = valute.getString("TJS");
                String tjs1 = tjs.substring(43,46);
                int valuteTjsStart = tjs.indexOf(":", 70);
                int valuteTjsEnds = tjs.indexOf(",\"Previous\"");
                String valuteTjs = tjs.substring(valuteTjsStart + 1, valuteTjsEnds);

                String tri = valute.getString("TRY");
                String tri1 = tri.substring(44,47);
                int valuteTriStart = tri.indexOf(":", 70);
                int valuteTriEnds = tri.indexOf(",\"Previous\"");
                String valuteTri = tri.substring(valuteTriStart + 1, valuteTriEnds);

                String tmt = valute.getString("TMT");
                String tmt1 = tmt.substring(44,47);
                int valuteTmtStart = tmt.indexOf(":", 70);
                int valuteTmtEnds = tmt.indexOf(",\"Previous\"");
                String valuteTmt = tmt.substring(valuteTmtStart + 1, valuteTmtEnds);

                String uzs = valute.getString("UZS");
                String uzs1 = uzs.substring(43,46);
                int valuteUzsStart = uzs.indexOf(":", 70);
                int valuteUzsEnds = uzs.indexOf(",\"Previous\"");
                String valuteUzs = uzs.substring(valuteUzsStart + 1, valuteUzsEnds);

                String uah = valute.getString("UAH");
                String uah1 = uah.substring(43,46);
                int valuteUahStart = uah.indexOf(":", 70);
                int valuteUahEnds = uah.indexOf(",\"Previous\"");
                String valuteUah = uah.substring(valuteUahStart + 1, valuteUahEnds);

                String czk = valute.getString("CZK");
                String czk1 = czk.substring(43,46);
                int valuteCzkStart = czk.indexOf(":", 70);
                int valuteCzkEnds = czk.indexOf(",\"Previous\"");
                String valuteCzk = czk.substring(valuteCzkStart + 1, valuteCzkEnds);

                String sek = valute.getString("SEK");
                String sek1 = sek.substring(43,46);
                int valuteSekStart = sek.indexOf(":", 70);
                int valuteSekEnds = sek.indexOf(",\"Previous\"");
                String valuteSek = sek.substring(valuteSekStart + 1, valuteSekEnds);

                String chf = valute.getString("CHF");
                String chf1 = chf.substring(43,46);
                int valuteChfStart = chf.indexOf(":", 70);
                int valuteChfEnds = chf.indexOf(",\"Previous\"");
                String valuteChf = chf.substring(valuteChfStart + 1, valuteChfEnds);

                String zar = valute.getString("ZAR");
                String zar1 = zar.substring(43,46);
                int valuteZarStart = zar.indexOf(":", 70);
                int valuteZarEnds = zar.indexOf(",\"Previous\"");
                String valuteZar = zar.substring(valuteZarStart + 1, valuteZarEnds);

                String krw = valute.getString("KRW");
                String krw1 = krw.substring(43,46);
                int valuteKrwStart = krw.indexOf(":", 70);
                int valuteKrwEnds = krw.indexOf(",\"Previous\"");
                String valuteKrw = krw.substring(valuteKrwStart + 1, valuteKrwEnds);

                String jpy = valute.getString("JPY");
                String jpy1 = jpy.substring(43,46);
                int valuteJpyStart = jpy.indexOf(":", 70);
                int valuteJpyEnds = jpy.indexOf(",\"Previous\"");
                String valuteJpy = jpy.substring(valuteJpyStart + 1, valuteJpyEnds);

                final String[] valuteNames = new String[] {
                        aud1, azn1, gbp1, amd1, byn1,
                        bgn1, huf1, hkd1, dkk1,
                        usd1, eur1, inr1, kzt1, cad1,
                        kgs1, cny1, mdl1, nok1, pln1,
                        ron1, xdr1, sgd1, tjs1, tri1,
                        tmt1, uzs1, uah1, czk1, sek1,
                        chf1, zar1, krw1, jpy1
                };

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, valuteNames);
                listView.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
