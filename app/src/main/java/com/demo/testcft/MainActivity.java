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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
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
    private TextView textViewShowValute;
    private EditText editTextEnterValute;
    private Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }

        listView = findViewById(R.id.listView);
        textViewShowValute = findViewById(R.id.textViewShowValute);
        editTextEnterValute = findViewById(R.id.editTextEnterValute);
        btnResult = findViewById(R.id.btnResult);
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
                int startAud = aud.indexOf("Value");
                int endAud = aud.indexOf(",\"Previous\"");
                String valueAud = aud.substring(startAud + 7, endAud);
                final double rezAud = Double.parseDouble(valueAud);

                String azn = valute.getString("AZN");
                String azn1 = azn.substring(44,47);
                int startAzn = azn.indexOf("Value");
                int endAzn = azn.indexOf(",\"Previous\"");
                String valueAzn = azn.substring(startAzn + 7, endAzn);
                final double rezAzn = Double.parseDouble(valueAzn);

                String gbp = valute.getString("GBP");
                String gbp1 = gbp.substring(43,46);
                int startGbp = gbp.indexOf("Value");
                int endGbp = gbp.indexOf(",\"Previous\"");
                String valueGbp = gbp.substring(startGbp + 7, endGbp);
                final double rezGbp = Double.parseDouble(valueGbp);

                String amd = valute.getString("AMD");
                String amd1 = amd.substring(43,46);
                int startAmd = amd.indexOf("Value");
                int endAmd = amd.indexOf(",\"Previous\"");
                String valueAmd = amd.substring(startAmd + 7, endAmd);
                final double rezAmd = Double.parseDouble(valueAmd);

                String byn = valute.getString("BYN");
                String byn1 = byn.substring(44,47);
                int startByn = byn.indexOf("Value");
                int endByn = byn.indexOf(",\"Previous\"");
                String valueByn = byn.substring(startByn + 7, endByn);
                final double rezByn = Double.parseDouble(valueAmd);

                String bgn = valute.getString("BGN");
                String bgn1 = bgn.substring(43,46);
                int startBgn = bgn.indexOf("Value");
                int endBgn = bgn.indexOf(",\"Previous\"");
                String valueBgn = bgn.substring(startBgn + 7, endBgn);
                final double rezBgn = Double.parseDouble(valueBgn);

                String brl = valute.getString("BRL");
                String brl1 = brl.substring(43,46);
                int startBrl = brl.indexOf("Value");
                int endBrl = brl.indexOf(",\"Previous\"");
                String valueBrl = brl.substring(startBrl + 7, endBrl);
                final double rezBrl = Double.parseDouble(valueBrl);

                String huf = valute.getString("HUF");
                String huf1 = huf.substring(43,46);
                int startHuf = huf.indexOf("Value");
                int endHuf = huf.indexOf(",\"Previous\"");
                String valueHuf = huf.substring(startHuf + 7, endHuf);
                final double rezHuf = Double.parseDouble(valueHuf);

                String hkd = valute.getString("HKD");
                String hkd1 = hkd.substring(43,46);
                int startHkd = hkd.indexOf("Value");
                int endHkd = hkd.indexOf(",\"Previous\"");
                String valueHkd = hkd.substring(startHkd + 7, endHkd);
                final double rezHkd = Double.parseDouble(valueHkd);

                String dkk = valute.getString("DKK");
                String dkk1 = dkk.substring(43,46);
                int startDkk = dkk.indexOf("Value");
                int endDkk = dkk.indexOf(",\"Previous\"");
                String valueDkk = dkk.substring(startDkk + 7, endDkk);
                final double rezDkk = Double.parseDouble(valueDkk);

                String usd = valute.getString("USD");
                String usd1 = usd.substring(43,46);
                int startUsd = usd.indexOf("Value");
                int endUsd = usd.indexOf(",\"Previous\"");
                String valueUsd = usd.substring(startUsd + 7, endUsd);
                final double rezUsd = Double.parseDouble(valueUsd);

                String eur = valute.getString("EUR");
                String eur1 = eur.substring(43,46);
                int startEur = eur.indexOf("Value");
                int endEur = eur.indexOf(",\"Previous\"");
                String valueEur = eur.substring(startEur + 7, endEur);
                final double rezEur = Double.parseDouble(valueEur);

                String inr = valute.getString("INR");
                String inr1 = inr.substring(43,46);
                int startInr = inr.indexOf("Value");
                int endInr = inr.indexOf(",\"Previous\"");
                String valueInr = inr.substring(startInr + 7, endInr);
                final double rezInr = Double.parseDouble(valueInr);

                String kzt = valute.getString("KZT");
                String kzt1 = kzt.substring(43,46);
                int startKzt = kzt.indexOf("Value");
                int endKzt = kzt.indexOf(",\"Previous\"");
                String valueKzt = kzt.substring(startKzt + 7, endKzt);
                final double rezKzt = Double.parseDouble(valueKzt);

                String cad = valute.getString("CAD");
                String cad1 = cad.substring(43,46);
                int startCad = cad.indexOf("Value");
                int endCad = cad.indexOf(",\"Previous\"");
                String valueCad = cad.substring(startCad + 7, endCad);
                final double rezCad = Double.parseDouble(valueCad);

                String kgs = valute.getString("KGS");
                String kgs1 = kgs.substring(43,46);
                int startKgs = kgs.indexOf("Value");
                int endKgs = kgs.indexOf(",\"Previous\"");
                String valueKgs = kgs.substring(startKgs + 7, endKgs);
                final double rezKgs = Double.parseDouble(valueKgs);

                String cny = valute.getString("CNY");
                String cny1 = cny.substring(43,46);
                int startCny = cny.indexOf("Value");
                int endCny = cny.indexOf(",\"Previous\"");
                String valueCny = cny.substring(startCny + 7, endCny);
                final double rezCny = Double.parseDouble(valueCny);

                String mdl = valute.getString("MDL");
                String mdl1 = mdl.substring(43,46);
                int startMdl = mdl.indexOf("Value");
                int endMdl = mdl.indexOf(",\"Previous\"");
                String valueMdl = mdl.substring(startMdl + 7, endMdl);
                final double rezMdl = Double.parseDouble(valueMdl);

                String nok = valute.getString("NOK");
                String nok1 = nok.substring(43,46);
                int startNok = nok.indexOf("Value");
                int endNok = nok.indexOf(",\"Previous\"");
                String valueNok = nok.substring(startNok + 7, endNok);
                final double rezNok = Double.parseDouble(valueNok);

                String pln = valute.getString("PLN");
                String pln1 = pln.substring(43,46);
                int startPln = pln.indexOf("Value");
                int endPln = pln.indexOf(",\"Previous\"");
                String valuePln = pln.substring(startPln + 7, endPln);
                final double rezPln = Double.parseDouble(valuePln);

                String ron = valute.getString("RON");
                String ron1 = ron.substring(44,47);
                int startRon = ron.indexOf("Value");
                int endRon = ron.indexOf(",\"Previous\"");
                String valueRon = ron.substring(startRon + 7, endRon);
                final double rezRon = Double.parseDouble(valueRon);

                String xdr = valute.getString("XDR");
                String xdr1 = xdr.substring(43,46);
                int startXdr = xdr.indexOf("Value");
                int endXdr = xdr.indexOf(",\"Previous\"");
                String valueXdr = xdr.substring(startXdr + 7, endXdr);
                final double rezXdr = Double.parseDouble(valueXdr);

                String sgd = valute.getString("SGD");
                String sgd1 = sgd.substring(43,46);
                int startSgd = sgd.indexOf("Value");
                int endSgd = sgd.indexOf(",\"Previous\"");
                String valueSgd = sgd.substring(startSgd + 7, endSgd);
                final double rezSgd = Double.parseDouble(valueSgd);

                String tjs = valute.getString("TJS");
                String tjs1 = tjs.substring(43,46);
                int startTjs = tjs.indexOf("Value");
                int endTjs = tjs.indexOf(",\"Previous\"");
                String valueTjs = tjs.substring(startTjs + 7, endTjs);
                final double rezTjs = Double.parseDouble(valueTjs);

                String tri = valute.getString("TRY");
                String tri1 = tri.substring(44,47);
                int startTri = tri.indexOf("Value");
                int endTri = tri.indexOf(",\"Previous\"");
                String valueTri = tri.substring(startTri + 7, endTri);
                final double rezTri = Double.parseDouble(valueTri);

                String tmt = valute.getString("TMT");
                String tmt1 = tmt.substring(44,47);
                int startTmt = tmt.indexOf("Value");
                int endTmt = tmt.indexOf(",\"Previous\"");
                String valueTmt = tmt.substring(startTmt + 7, endTmt);
                final double rezTmt = Double.parseDouble(valueTmt);

                String uzs = valute.getString("UZS");
                String uzs1 = uzs.substring(43,46);
                int startUzs = uzs.indexOf("Value");
                int endUzs = uzs.indexOf(",\"Previous\"");
                String valueUzs = uzs.substring(startUzs + 7, endUzs);
                final double rezUzs = Double.parseDouble(valueUzs);

                String uah = valute.getString("UAH");
                String uah1 = uah.substring(43,46);
                int startUah = uah.indexOf("Value");
                int endUah = uah.indexOf(",\"Previous\"");
                String valueUah = uah.substring(startUah + 7, endUah);
                final double rezUah = Double.parseDouble(valueUah);

                String czk = valute.getString("CZK");
                String czk1 = czk.substring(43,46);
                int startCzk = czk.indexOf("Value");
                int endCzk = czk.indexOf(",\"Previous\"");
                String valueCzk = czk.substring(startCzk + 7, endCzk);
                final double rezCzk = Double.parseDouble(valueCzk);

                String sek = valute.getString("SEK");
                String sek1 = sek.substring(43,46);
                int startSek = sek.indexOf("Value");
                int endSek = sek.indexOf(",\"Previous\"");
                String valueSek = sek.substring(startSek + 7, endSek);
                final double rezSek = Double.parseDouble(valueSek);

                String chf = valute.getString("CHF");
                String chf1 = chf.substring(43,46);
                int startChf = chf.indexOf("Value");
                int endChf = chf.indexOf(",\"Previous\"");
                String valueChf = chf.substring(startChf + 7, endChf);
                final double rezChf = Double.parseDouble(valueChf);

                String zar = valute.getString("ZAR");
                String zar1 = zar.substring(43,46);
                int startZar = zar.indexOf("Value");
                int endZar = zar.indexOf(",\"Previous\"");
                String valueZar = zar.substring(startZar + 7, endZar);
                final double rezZar = Double.parseDouble(valueZar);

                String krw = valute.getString("KRW");
                String krw1 = krw.substring(43,46);
                int startKrw = krw.indexOf("Value");
                int endKrw = krw.indexOf(",\"Previous\"");
                String valueKrw = krw.substring(startKrw + 7, endKrw);
                final double rezKrw = Double.parseDouble(valueKrw);

                String jpy = valute.getString("JPY");
                String jpy1 = jpy.substring(43,46);
                int startJpy = jpy.indexOf("Value");
                int endJpy = jpy.indexOf(",\"Previous\"");
                String valueJpy = jpy.substring(startJpy + 7, endJpy);
                final double rezJpy = Double.parseDouble(valueJpy);

                final String[] valuteNames = new String[] {
                        aud1, azn1, gbp1, amd1, byn1,
                        bgn1, brl1, huf1, hkd1, dkk1,
                        usd1, eur1, inr1, kzt1, cad1,
                        kgs1, cny1, mdl1, nok1, pln1,
                        ron1, xdr1, sgd1, tjs1, tri1,
                        tmt1, uzs1, uah1, czk1, sek1,
                        chf1, zar1, krw1, jpy1
                };

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, valuteNames);
                listView.setAdapter(adapter);


                final Spinner mySpinner = (Spinner)findViewById(R.id.spinnerValute);

                btnResult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String finalCount = editTextEnterValute.getText().toString();
                        if(!finalCount.isEmpty()){
                            final String spinnerValue = mySpinner.getSelectedItem().toString();
                            final double count1 = Double.parseDouble(finalCount);
                            switch (spinnerValue) {
                                case "AUD":
                                    double result = count1 / rezAud;
                                    String res = Double.toString(result);
                                    textViewShowValute.setText(res);
                                    break;
                                case "AZN":
                                    double result1 = count1 / rezAzn;
                                    String res1 = Double.toString(result1);
                                    textViewShowValute.setText(res1);
                                    break;
                                case "GBP":
                                    double result2 = count1 / rezGbp;
                                    String res2 = Double.toString(result2);
                                    textViewShowValute.setText(res2);
                                    break;
                                case "AMD":
                                    double result3 = count1 / rezAmd;
                                    String res3 = Double.toString(result3);
                                    textViewShowValute.setText(res3);
                                    break;
                                case "BYN":
                                    double result4 = count1 / rezByn;
                                    String res4 = Double.toString(result4);
                                    textViewShowValute.setText(res4);
                                    break;
                                case "BGN":
                                    double result5 = count1 / rezBgn;
                                    String res5 = Double.toString(result5);
                                    textViewShowValute.setText(res5);
                                    break;
                                case "BRL":
                                    double result6 = count1 / rezBrl;
                                    String res6 = Double.toString(result6);
                                    textViewShowValute.setText(res6);
                                    break;
                                case "HUF":
                                    double result7 = count1 / rezHuf;
                                    String res7 = Double.toString(result7);
                                    textViewShowValute.setText(res7);
                                    break;
                                case "HKD":
                                    double result8 = count1 / rezHkd;
                                    String res8 = Double.toString(result8);
                                    textViewShowValute.setText(res8);
                                    break;
                                case "DKK":
                                    double result9 = count1 / rezDkk;
                                    String res9 = Double.toString(result9);
                                    textViewShowValute.setText(res9);
                                    break;
                                case "USD":
                                    double result10 = count1 / rezUsd;
                                    String res10 = Double.toString(result10);
                                    textViewShowValute.setText(res10);
                                    break;
                                case "EUR":
                                    double result11 = count1 / rezEur;
                                    String res11 = Double.toString(result11);
                                    textViewShowValute.setText(res11);
                                    break;
                                case "INR":
                                    double result12 = count1 / rezInr;
                                    String res12 = Double.toString(result12);
                                    textViewShowValute.setText(res12);
                                    break;
                                case "KZT":
                                    double result13 = count1 / rezKzt;
                                    String res13 = Double.toString(result13);
                                    textViewShowValute.setText(res13);
                                    break;
                                case "CAD":
                                    double result14 = count1 / rezCad;
                                    String res14 = Double.toString(result14);
                                    textViewShowValute.setText(res14);
                                    break;
                                case "KGS":
                                    double result15 = count1 / rezKgs;
                                    String res15 = Double.toString(result15);
                                    textViewShowValute.setText(res15);
                                    break;
                                case "CNY":
                                    double result16 = count1 / rezCny;
                                    String res16 = Double.toString(result16);
                                    textViewShowValute.setText(res16);
                                    break;
                                case "MDL":
                                    double result17 = count1 / rezMdl;
                                    String res17 = Double.toString(result17);
                                    textViewShowValute.setText(res17);
                                    break;
                                case "NOK":
                                    double result18 = count1 / rezNok;
                                    String res18 = Double.toString(result18);
                                    textViewShowValute.setText(res18);
                                    break;
                                case "PLN":
                                    double result19 = count1 / rezPln;
                                    String res19 = Double.toString(result19);
                                    textViewShowValute.setText(res19);
                                    break;
                                case "RON":
                                    double result20 = count1 / rezRon;
                                    String res20 = Double.toString(result20);
                                    textViewShowValute.setText(res20);
                                    break;
                                case "XDR":
                                    double result21 = count1 / rezXdr;
                                    String res21 = Double.toString(result21);
                                    textViewShowValute.setText(res21);
                                    break;
                                case "SGD":
                                    double result22 = count1 / rezSgd;
                                    String res22 = Double.toString(result22);
                                    textViewShowValute.setText(res22);
                                    break;
                                case "TJS":
                                    double result23 = count1 / rezTjs;
                                    String res23 = Double.toString(result23);
                                    textViewShowValute.setText(res23);
                                    break;
                                case "TRI":
                                    double result24 = count1 / rezTri;
                                    String res24 = Double.toString(result24);
                                    textViewShowValute.setText(res24);
                                    break;
                                case "TMT":
                                    double result25 = count1 / rezTmt;
                                    String res25 = Double.toString(result25);
                                    textViewShowValute.setText(res25);
                                    break;
                                case "UZS":
                                    double result26 = count1 / rezUzs;
                                    String res26 = Double.toString(result26);
                                    textViewShowValute.setText(res26);
                                    break;
                                case "UAH":
                                    double result27 = count1 / rezUah;
                                    String res27 = Double.toString(result27);
                                    textViewShowValute.setText(res27);
                                    break;
                                case "CZK":
                                    double result28 = count1 / rezCzk;
                                    String res28 = Double.toString(result28);
                                    textViewShowValute.setText(res28);
                                    break;
                                case "SEK":
                                    double result29 = count1 / rezSek;
                                    String res29 = Double.toString(result29);
                                    textViewShowValute.setText(res29);
                                    break;
                                case "CHF":
                                    double result30 = count1 / rezChf;
                                    String res30 = Double.toString(result30);
                                    textViewShowValute.setText(res30);
                                    break;
                                case "ZAR":
                                    double result31 = count1 / rezZar;
                                    String res31 = Double.toString(result31);
                                    textViewShowValute.setText(res31);
                                    break;
                                case "KRW":
                                    double result32 = count1 / rezKrw;
                                    String res32 = Double.toString(result32);
                                    textViewShowValute.setText(res32);
                                    break;
                                case "JPY":
                                    double result33 = count1 / rezJpy;
                                    String res33 = Double.toString(result33);
                                    textViewShowValute.setText(res33);
                                    break;
                                default:
                                    textViewShowValute.setText("Не получилось");
                                    break;
                            }
                        }
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
