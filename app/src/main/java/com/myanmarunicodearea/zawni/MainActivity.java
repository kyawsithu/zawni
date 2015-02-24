package com.myanmarunicodearea.zawni;

import android.app.Activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.myanmarunicodearea.zawni.util.Zawgyi2Unicode;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)
public class MainActivity extends ActionBarActivity {

    @ViewById
    WebView mWebView;

    //@ViewById
    //EditText mTextUrl;

    Activity mActivity;

    @AfterViews
    void afterView() {
        mActivity = this;
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                mActivity.setTitle("Loading...");
                mActivity.setProgress(progress * 100);
                if (progress == 100)
                    mActivity.setTitle("");
            }
        });
        mWebView.setWebViewClient(new WebViewClient());
        //mWebView.loadUrl("http://www.google.com");

        String input_text=" တန္ေဆာင္တုိင္ပြဲမွာ ထိပ္ထားတုိ႔ ေသာတာပန္ရပ္ကြက္က ဦးစီးၿပီးေတာ့ အပ်ိဳလူပ်ိဳ အငွားပစၥည္းေတြ ထပ္ဝယ္ဖုိ႔အတြက္ ဝကၤပါပြဲနဲ႔ စတိတ္႐ႈိးလ္ လုပ္တယ္။ ရပ္ကြက္မွဴးက ရပ္ကြက္ထဲက ဂီတနဲ႔ ပတ္သက္ၿပီး လက္စလက္န႐ွိတဲ့ မိမိတုိ႔အဖြဲ႔ကို ဆရာတင္တယ္။ ေက်ာ္ႀကီးနဲ႔ ခ်ဥ္ေပါင္ေၾကာ္တုိ႔ကလည္း ဂစ္တာနဲ႔ ပတ္သက္ရင္ စင္ေပၚ တက္တီးႏုိင္ေလာက္တဲ့အထိ အေလ့အက်င့္ ရေနၾကၿပီး ပီတူးကလည္း ဒရမ္အတီးကို မႏၱေလးမွာ ဇာတ္နဲ႔ လုိက္တီးဖူးသူ။ ထိပ္ထားကလည္း အဆုိေရာ၊ အတီးေရာ ရသူေတြမုိ႔ ႐ႈိးလ္ပြဲ လုပ္ျဖစ္ၾကတယ္။\n" +
                "\n" +
                "ျဖစ္ခ်င္ ေတာ့ ထိပ္ထားဆုိတဲ့ သီခ်င္းသံုးပုဒ္စလံုးမွာ အဝတ္အစားနဲ႔ ကုိယ္ပုိင္စတုိင္ေတြ အားလံုးကို သီခ်င္းနဲ႔ လိုက္ဖက္ေစခ်င္တယ္။ တစ္ပုဒ္က အငဲရဲ႕ ညမီးအိမ္၊ တစ္ပုဒ္က ၿဖိဳးႀကီးရဲ႕ အထည္ႀကီးပ်က္ သီခ်င္း။ သီခ်င္းနဲ႔ လုိက္ဖက္ဖုိ႔ ပလက္တီနမ္ဆြဲႀကိဳးကို စစ္ကုိင္းတၿမိဳ႕လံုး ႐ွာတာ၊ နယ္ၿမိဳ႕ဆုိေတာ့ လံုးဝ ႐ွာမရဘူး။ ကုိယ့္သီခ်င္းနဲ႔လည္း လုိက္ဖက္ေစခ်င္တယ္ဆုိေတာ့ ေမေမရဲ႕ မႏွဲေလး ဆက္ထားတဲ့ လင္းလင္းလက္လက္ ဘယက္ကံုးႀကီးကို ေမေမ မသိေအာင္ ႏွစ္ရက္ေလာက္ကတည္းက ႀကိဳခုိးထားလုိက္တယ္။ ေတာင္းလုိ႔၊ ခဏ ငွားလုိ႔လည္း ရမွာမဟုတ္။ အေမက အရမ္း အယူသည္းတာမုိ႔ အေမ မသိခင္ ခုိးထားလုိက္တာ။ ေမးေတာ့ ေမးေသးတယ္။";
        String input_text2="လောက အလှကို ဘယ်သူ တစ်ဦး တစ်ယောက်တည်းနဲ့ မှာ ဖန်တီးယူလို့ မရပါဘူး။ သူ့ နေရာနဲ့ သူ\n" +
                "ကိုယ်စီတာ၀န် ခွဲဝေယူမှသာလျှင် လောကကို လှအောင်ဖန်တီးလို့ ရနိုင်မှာပါ။ လဲနေသူ ထူပေးခြင်းဖြင့်\n" +
                "ပတ်၀န်းကျင်ကို အလှဆင်ပေးပါ။\n" +
                "\n" +
                "ပန်းခင်းကို ပျိုးထောင်တဲ့သူက ပျိုးထောင်ထားပေမယ့် ပတ်၀န်းကျင်ကလည်း ပန်းဆိုတာကို တန်ဖိုး\n" +
                "ထားတက်မှ ဖြစ်မည်။ ဒီလိုမှမဟုတ်ပဲ ပျိုးတဲ့သူကပျိုး၊ ဖျက်တဲ့သူက ဖျက်ဆိုရင် အလှတရားဆိုတာ\n" +
                "ဘယ်ရှိလာတော့မလဲ။ ပတ်၀န်းကျင်လှဖို့ မိမိတို့ ကိုယ်စီဟာ အလှဖန်တီးရှင်များ ဖြစ်တယ်ဆိုတာ သိ\n" +
                "ပါစေ။";

        CharSequence text = Zawgyi2Unicode.autoConverted(input_text);
        CharSequence text2 = Zawgyi2Unicode.autoConverted(input_text2);

        Toast.makeText(this, "Zawgyi = "+Zawgyi2Unicode.isZawgyiCheck(input_text), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Unicode = "+Zawgyi2Unicode.isUnicodeCheck(input_text), Toast.LENGTH_SHORT).show();
        String htmlData="<html><head><meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" /></head><body>"+"Zawgyi = "+Zawgyi2Unicode.isZawgyiCheck(input_text)+"<br>"+"Unicode = "+Zawgyi2Unicode.isUnicodeCheck(input_text)+"<br>"+text+"<br>"+"Zawgyi = "+Zawgyi2Unicode.isZawgyiCheck(input_text2)+"<br>"+"Unicode = "+Zawgyi2Unicode.isUnicodeCheck(input_text2)+"<br>"+text2 + "</body></html>";
        //Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        mWebView.loadData(htmlData, "text/html; charset=utf-8", "utf-8");

    }

}
