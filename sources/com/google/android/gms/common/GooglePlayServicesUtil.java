package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.C0076R;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.fd;
import com.google.android.gms.internal.fi;
import com.google.android.gms.internal.gk;
import com.google.android.gms.internal.gr;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class GooglePlayServicesUtil {
    static final byte[][] Aj = new byte[][]{ag("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u00000t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android0\u001e\u0017\r080821231334Z\u0017\r360107231334Z0t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000«V.\u0000Ø;¢\b®\no\u0012N)Ú\u0011ò«VÐXâÌ©\u0013\u0003é·TÓrö@§\u001b\u001dË\u0013\tgbNFV§wj\u0019=²å¿·$©\u001ew\u0018\u000ejG¤;3Ù`w\u00181EÌß{.XftÉáV[\u001fLjYU¿òQ¦=«ùÅ\\'\"\"Rèuäø\u0015Jd_qhÀ±¿Æ\u0012ê¿xWi»4ªyÜ~.¢vL®\u0007ØÁqT×î_d¥\u001aD¦\u0002ÂI\u0005AWÜ\u0002Í_\\\u000eUûï\u0019ûã'ð±Q\u0016Å o\u0019ÑõÄÛÂÖ¹?hÌ)yÇ\u000e\u0018«k;ÕÛU*\u000e;LßXûíÁº5à\u0003Á´±\rÒD¨î$ÿý38r«R!^Ú°ü\r\u000b\u0014[j¡y\u0002\u0001\u0003£Ù0Ö0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014Ç}Â!\u0017V%Óßkãä×¥0¦\u0006\u0003U\u001d#\u00040\u0014Ç}Â!\u0017V%Óßkãä×¥¡x¤v0t1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android\t\u0000ÂàFdJ00\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0001\u0001\u0000mÒRÎï0,6\nªÎÏòÌ©\u0004»]z\u0016aø®F²B\u0004ÐÿJhÇí\u001aS\u001eÄYZb<æ\u0007c±g)zzãW\u0012Ä\u0007ò\bðË\u0010)\u0012M{\u0010b\u0019ÀÊ>³ù­_¸qï&âñmDÈÙ l²ð\u0005»?âËD~s\u0010v­E³?`\tê\u0019Áaæ&Aª'\u001dýR(ÅÅ]ÛE'XÖaöÌ\fÌ·5.BLÄ6\\R52÷2Q7Y<JãAôÛAíÚ\r\u000b\u0010q§Ä@ðþ \u001c¶'ÊgCiÐ½/Ù\u0011ÿ\u0006Í¿,ú\u0010Ü\u000f:ãWbHÇïÆLqD\u0017B÷\u0005ÉÞW:õ[9\r×ý¹A1]_u0\u0011&ÿb\u0014\u0010Ài0"), ag("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u000001\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u001e\u0017\r080415233656Z\u0017\r350901233656Z01\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000ÖÎ.\b\n¿â1MÑ³ÏÓ\u0018\\´=3ú\ftá½¶ÑÛ\u0013ö,\\9ßVøF=e¾ÀóÊBk\u0007Å¨íZ9ÁgçkÉ¹'K\u000b\"\u0000\u0019©)\u0015årÅm*0\u001b£oÅü\u0011:ÖËt5¡m#«}úîáeäß\u001f\n½§\nQlN\u0005\u0011Ê|\fU\u0017[ÃuùHÅj®\b¤O¦¤Ý}¿,\n5\"­\u0006¸Ì\u0018^±Uyîøm\b\u000b\u001daÀù¯±ÂëÑ\u0007êE«Ûh£Ç^TÇlSÔ\u000b\u0012\u001dç»Ó\u000eb\f\u0018áªaÛ¼Ý<d_/UóÔÃuì@p©?qQØ6pÁj\u001a¾^òÑ\u0018á¸®ó)ðf¿láD¬èm\u001c\u001b\u000f\u0002\u0001\u0003£ü0ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014\u001cÅ¾LC<a:\u0015°L¼\u0003òOà²0É\u0006\u0003U\u001d#\u0004Á0¾\u0014\u001cÅ¾LC<a:\u0015°L¼\u0003òOà²¡¤01\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com\t\u0000Õ¸l}ÓNõ0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0001\u0001\u0000\u0019Ó\fñ\u0005ûx?L\r}Ò##=@zÏÎ\u0000\b\u001d[×ÆéÖí k\u000e\u0011 \u0006Al¢D\u0013ÒkJ àõ$ÊÒ»\\nL¡\u0001j\u0015n¡ì]ÉZ^:\u0001\u00006ôHÕ\u0010¿.\u001eag:;åm¯\u000bw±Â)ãÂUãèL]#ïº\tËñ; +NZ\"É2cHJ#Òü)ú\u00199u3¯Øª\u0016\u000fBÂÐ\u0016>fCéÁ/ Á33[Àÿk\"ÞÑ­DB)¥9©Nï­«ÐeÎÒK>QåÝ{fx{ï\u0012þû¤Ä#ûOøÌIL\u0002ðõ\u0005\u0016\u0012ÿe)9>FêÅ»!òwÁQª_*¦'Ñè§\n¶\u00035iÞ;¿ÿ|©Ú>\u0012Cö\u000b")};
    static final byte[][] Ak = new byte[][]{ag("0\u0002R0\u0001»\u0002\u0004I4~0\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u00000p1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u000b0\t\u0006\u0003U\u0004\b\u0013\u0002CA1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle, Inc1\u00140\u0012\u0006\u0003U\u0004\u000b\u0013\u000bGoogle, Inc1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Unknown0\u001e\u0017\r081202020758Z\u0017\r360419020758Z0p1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u000b0\t\u0006\u0003U\u0004\b\u0013\u0002CA1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle, Inc1\u00140\u0012\u0006\u0003U\u0004\u000b\u0013\u000bGoogle, Inc1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Unknown00\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u00000\u0002\u0000H\u0003\u0019ù±G&8N\u0004SÑ\u000b¿Ç{%\u0004¤± |LlDº¼\u0000­Æa\u000f¦¶«-¨\u000e3òîñk&£ö¸[úÊû¾³ôÉO~\"§àë§\\í=Ò)úseô\u0015\u0016AZ©Áa}ÕÎ\u0019ºè »Øü\u0017©´½&@Q!ªÛwÞ´\u0000\u00138\u0014\u0018.Å\"üX\r\u0002\u0003\u0001\u0000\u00010\r\u0006\t*H÷\r\u0001\u0001\u0004\u0005\u0000\u0003\u0000@fÖ1ÚCÝÐaÒ&às¹Ä¹øµä¾<¾P\u001eß\u001co©YÀÎ`\\OÒ¬m\u001cÎÞ Glº±èò :ÿw\u0017­e-Ì\u0007\bÑ!m¨DWY&IàéÓÄ»Lõ¡±ÔüA¼¹XOdæ_A\r\u0005)ý[h\u0014\u001d\nÑÛ\u0011Ë*\r÷ê\f±-³¤"), ag("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000~OòÖµÞ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u000001\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u001e\u0017\r100120010135Z\u0017\r370607010135Z01\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000Ø(q|6Ñ\u0017\u000fÔM\n{\u000f\u0007\u0011&è[¿ß3°4`\u0000ZÌûe¥Û ²Cß`±¿\u0006ß\u001d\\\n3âÑcõ\u0013ß\u001d\"SAê<3y\"è\\\u0002ì4ÎÙL¸\u0007#¦#ÿK¯û´åïæw;>¢¾¸¼²\u0002gÏçQ\u001f.ù«uþ\u001e)Ï¼M\b:\u001f\u0012R\u0000wsò\u0016[i{\u0000£ Á:Ì0ò!cÁn=J²\u00146LEÀC\u00142p9ñÚ\t`ñ³ü\u0018¶V\u0010Æ\"_Ç\u0010+|o\u0013¤]$ãàÅNgã[g\b'\u0013ÒÖðWÝ4WÑÄþÝì:O?#\u0005\u0019§\n(64¬5£J½¡}Z\n\tûø\u0006\u000b\u0003j'x`cú\f7¹çò¡\u000ev¼w\u0002\u0001\u0003£ü0ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014µÇù\u0012ox\r:ûÊess?õ\"k\u001770É\u0006\u0003U\u001d#\u0004Á0¾\u0014µÇù\u0012ox\r:ûÊess?õ\"k\u00177¡¤01\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00100\u000e\u0006\u0003U\u0004\u0003\u0013\u0007Android1\"0 \u0006\t*H÷\r\u0001\t\u0001\u0016\u0013android@android.com\t\u0000~OòÖµÞ0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u0000L>§e}&æ»×\u0011\f\u0019ß\u001f¡\t}3\u000fiÞ¿ÊÛF£~å³\u000f»4{\u001cuU¼»<T\u0014F_y*\u0002ÐÛå¦Ga³yG«kÿ°ºÆ¢Á Íøbøw©g\rýo\u0006.@nÎ\u0018\u0006\f`Iü6'\u0011qåoË¡Ræ\u0005ÎÎY\u001fÄô©+3ºØ\u0019mwoU·Ð\u001aÏ1Ý×\fì·xv\u0006e\u0010ùI¥RJ11³ËeAÏ5B\u000e¼ÄR%Y?Bfi\u0005rfbO³ÏÛR\u0017\u001d\u0011\u001cn\u0003F\u0016øQ!\u0018Ð¢¦\u0013×ðÍ\u0011ÛÕ#ZT¥JÂQçÒ,Dj?î\u0014\u0012\u0010éDGK@c\u0007»&+OkÓU\u001csQÿ¢`[\u0005â$×\u0015Øzö")};
    static final byte[][] Al = new byte[][]{ag("0\u0002§0\u0002e \u0003\u0002\u0001\u0002\u0002\u0004P\u0005|B0\u000b\u0006\u0007*HÎ8\u0004\u0003\u0005\u0000071\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00160\u0014\u0006\u0003U\u0004\u0003\u0013\rAndroid Debug0\u001e\u0017\r120717145250Z\u0017\r220715145250Z071\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00100\u000e\u0006\u0003U\u0004\n\u0013\u0007Android1\u00160\u0014\u0006\u0003U\u0004\u0003\u0013\rAndroid Debug0\u0001·0\u0001,\u0006\u0007*HÎ8\u0004\u00010\u0001\u001f\u0002\u0000ýS\u001du\u0012)RßJ.ìäçö\u0011·R<ïD\u0000Ã\u001e?¶Q&iE]@\"QûY=Xú¿Åõº0öËUl×;\u001d4oòf`·kP¥¤è\u0004{\u0010\"ÂO»©×þ·Æ\u001bø;WçÆ¨¦\u0015\u000f\u0004ûöÓÅ\u001eÃ\u00025T\u0013Z\u00162öuó®+a×*ïò\"\u0003\u0019ÑH\u0001Ç\u0002\u0015\u0000`P\u0015#\u000bÌ²¹¢ë\u000bðX\u001cõ\u0002\u0000÷á Ö=ÞË¼«\\6¸W¹y¯»ú:êùWL\u000b=\u0007gQYWºÔYOæq\u0007\u0010´I\u0016q#èL(\u0016\u0013·Ï\t2È¦á<\u0016zT|(à£®\u001e+³¦un£\u000bú!5bñûbz\u0001$;Ì¤ñ¾¨Q¨ßáZå\u0006f^{U%d\u0001L;þÏI*\u0003\u0000\u0002jÑ\u001b×ÕfÒzô9À.Ah¬ýE´¾¼{\u001cwTi?\rB¤üá\u00108BO¦Ñ0RNïöñ78c/¦7)þMF ¸feîðA\u00179\u0001\u0003[\u001cj£\u0018\u0018\r0:¨ÌY#àjo«úuh<E;²\u0007w|òýçÏ±\u001408\u0014ª\u001d÷´=[\"+W\u0006´0\u000b\u0006\u0007*HÎ8\u0004\u0003\u0005\u0000\u0003/\u00000,\u0002\u0014\tÒÑ°G\u0002)µ¾Ò&aÑ\u0012òpÅæ\u001d\u0002\u0014gP\u0002\u0006§Pºx®Ç\u0017O\u0016\u0004ê¢÷")};
    static final byte[][] Am = new byte[][]{ag("0\u0004L0\u00034 \u0003\u0002\u0001\u0002\u0002\t\u0000¨Í\u0017É=¥Ù0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u00000w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u001e\u0017\r110324010653Z\u0017\r380809010653Z0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000Ã\u000f­Ù´\tj,XjZ5kú\u0002iXøÿ\f]úõI&ØpÞè!¥>\u001f[\u0017\u000fÉbE£É§ËE'\u0005;ã^4óÒK\"ì\fRn&teàhuêb\u001fù@ã4[ I\u0007ÌTt:ÍªÎeV_HºtÍA!ÍÈvß5\"ºÛ\t\\ Ù4Åj>\\9>åðà/àb\u001f\u001f5¨$%,o¦¶3§hk>Ha-\u0006©ÏoI¿ñ\u001d](þ\u0014¬WbCÝ)êý¹\rã&5\u0013©\u0005¬¯ ~Fu\nZ·¿w&/G°?Z<nm{Q4?iÇ÷%÷\u000bÌ\u001bJÕ%\u000bpZæè>â®7þW\u0001¼½²oîýÿö\u000fj[ßµ¶G\u0002\u0001\u0003£Ü0Ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014\u001cÎÎ\u000eêMÁ\u0012\u001fÇQ_\r\n\fràÉm0©\u0006\u0003U\u001d#\u0004¡0\u0014\u001cÎÎ\u000eêMÁ\u0012\u001fÇQ_\r\n\fràÉm¡{¤y0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC\t\u0000¨Í\u0017É=¥Ù0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u0000¤pÇ(áÓ\u001b\u0006Ù¯jçhµe\u0004lWkCrI1×]L¡\f2\u0015 Ó<Ïí*¦Tb#Lù¶ù\u0010ÌgkËÖÀgcWO»x3\u0012uÜ\\óº©\u0018×\u0005\u001fû¢­èó\u0003ÍèÙæ\u0004\u001fÛ|*I²\"ÆÿB+ñUi¸^îí°J£\bsÛæKtøòÂöÄ\u0001$ª¨Ñx\r\u0018Q+T\nÝ(³éX\u0019q¤\u0017\rØhÏ_1äG\u0012²Â;µ\u00107×ï¦å½³^,ëk°\"cl\u0017¥j¼zP%\u000bÒí{1UZ\u0018E.\u00172\u001a\rRö?t-tÿyXj\\»¯q¨KÏtC\u0010éé'Y\u0000¢=Ð\u0006`\f\"8Ù\u000b/³rßÛºu½."), ag("0\u0004L0\u00034 \u0003\u0002\u0001\u0002\u0002\t\u0000Þv\u0004\u001dvPÀ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u00000w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u001e\u0017\r110324010324Z\u0017\r380809010324Z0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000æÿ=ïé*¡\rqë\u000f¦@À6·âCîíh¦¤v=Ç¥*1u|ÚÆ\u001få\u0010»sÇ\u0016ä\u0000\u0001\u0004&[4ÎÎôÄ+ñá7Ð¨vð(\"»Áù½Õ×\u0013²ö©5£yÒË©ÉoÒÐx|\u0011ñë\u0019T\b¦ r³Klú\ná'gé\u0000u0\u0016i¡\u001cïFÎ÷Ç\u0004mÞ1û`(M\u0012\n°çÞ\u001dc?\u0007h}FQ\u0013ÿýÆ¼ |©\u0004¸¾\u001d ª{NuoC`d¾\\®<hè»yBÍõ\u0016\u0007É0¢üÚe[uÐuº­\u0006ç9½\u000b¢\u001f@BÂÀ¨ZZ°ÐgÆÃìI! B¬c§å;Tle´`´ãæâ>\u001fwÏçöÞtK\u001ae\u0002\u0001\u0003£Ü0Ù0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014¢èd°]\b\\4Û\n\u0000P\u0011zì0©\u0006\u0003U\u001d#\u0004¡0\u0014¢èd°]\b\\4Û\n\u0000P\u0011zì¡{¤y0w1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00130\u0011\u0006\u0003U\u0004\u0003\u0013\nGoogle NFC\t\u0000Þv\u0004\u001dvPÀ0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u00007q\fè|<Rê0ÆébÙKM_\u0012Â]&\u0015AýµU]\u0012Îó¸1,?]ö¨ªàL¹³\u0005ä'ý\u001d-\u0019áÒxñ<R\u000f\u0018!\u0002cØÔ½6QHØØº&Ø¹¿\tõý>»\u000e£ÂðÉ7o\u001e\u001fÊvó¦¤\u0005B\b\u001bu*z·Vé«DÚA«ÈáèøÂu§CûsæPqW\fËkzÝ!¹ÆäVá,\"=\\\u0007JßUö«Ú&-dê\nEîÍ´\u0012~uÇSÃÿ0ËÆxµ\u001cR\u0014rñ}¢\n\rÆ'J¢F44Á©¶\u0014ßi}õÊ\u0001ç¢\\}³û\u0005]eV\u0004°\u001d8«ºW³¡p>ÂçJÓ4")};
    static final byte[][] An = new byte[][]{ag("0\u0005a0\u0003K\u0002\u0006\u0001DÓ0\u000b\u0006\t*H÷\r\u0001\u0001\u00050v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\u0013\tClockWork0\u001e\u0017\r140307220225Z\u0017\r380119031407Z0v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\u0013\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\u0013\tClockWork0\u0002\"0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0002\u000f\u00000\u0002\n\u0002\u0002\u0001\u0000º<9\u000bþYb¼ü<Æ'Z\u0015íÜÝ7:Uj\u000bâýC÷\u0018³\u0001Ò@'ãr\tÎýâ|&° Þ6}\u001aßãN§®7óõà&rzN\b(;ïvøöC¼\u0015'6 H?É·«R<ó½{f-*'L\u0000Øç\u0011è°&_í©uÜÈåB\u0013jbq.\u000b/9yQÛ$±W¡¿çÅkÎJ8\u000b%ú¹&c>¨\u00048à¶\u000b¹~.ú\u0005<2)Ùao¤½!{7C\u001fÍØí!§òðFà\u001c¼ZbãJ\u0015káZ\u0017ÿ\u0002\u0017dDÖ\u0013±\u001e×_\u0018î´ýäZã\u001cä¯¤68¶,\\ÒÛ\n\u0001Ä2a(äÅ\u0019z¾¬ÌmÂè­¤B_\u000fÕ¥¥X$a¿x\u0011á.Î\u000eê\u0006\u0003?T9íàqÿÄl òß¾##:dÁÎ\t­¡ËÎkö¼¢.JÀÉjluOì\u0018qØ{\u0010Á Þ`¼}wÞ0ÕN¸GÎk\u0012|\u0019\u001e§o\nFÁFó6¹4êºZ_\u001c\u0003d·RUD2Pýcªå{ë«à&?\t\bM\u0019D\u0006\f:Ù»ºyôÞ<+-7º³\rK¹\u0011ÜQià¯RôÓ=³òË\u001cR\u0002Rpa¿\u0001°BÐ~ä\u0011©ª 'ðDÚ(ÅÝØSW§\u001e9»Q³Wëor\u0018üÌ\u0017\u0018¦0gF1àU9\u001azgòZ b\u0001Ö\"¸Ð\tÝ\u0011Õ\u0006¢\u0003\u000f$'®gØ\u001b47yy\u0002\u0003\u0001\u0000\u00010\u000b\u0006\t*H÷\r\u0001\u0001\u0005\u0003\u0002\u0001\u0000¤Ä4aÈ5¥±\nÍ\u0001$7jÚ'C¬0\u0003Hg\u000b +­ã?/º*\u0007d\u0003µ\u000bèqÊ*²¾½»Ä\u0006Û\t9AÉ\u0017j\u000eFÿÿ\u0000\u0016\u0016\u0004DnÜá0þ\u0010\u001eã\u0005·~=©¢­4©Ò´Ú\u001b&ýZ[p\u001cÕlþédzä\u0014;¦|\u0002e±\u0014ò2¥ï\u0017ád¡I\u0017\u001c0½Z6«øóBÈã¯¼oICs\u0007}j\u0011×9\"\rZ×µ\u0019/\u001cþJr±¸Tuàé¾hrfe±+ôîÃ\"VTõáò+ëU¾fwÖ_\t-ù^þï\u000fÇêÊ]\u000e¾\u001dA\u0004\u001fç Ë20~9.\u0013ñ 9Ti0\u0002\u0017@-öÇ rçß8ºÃ×\"5oæTj|WßgÉ=+5T5ðù¡\u0013Î-ìÍm¡ÃKAì®Ö ëR0%Åà\u0004ì´Q¼EáHZÌ6¶I¯YLU\u001b\u000bÉ8ËÖ\u001aÕgY ÷:eá©È¤Û¬\u001eë\f)\t^ÞA\u0005{<®êN\u0016Å¹EKâY\u0011´¢\u001f?z¿Àgô\u0018.A¤ä4ð/í¯WrJU3WÚ_³ÍüùTÿØÉQwçu\u0004¦B¾\\Û á\u0000eü|h\u0012í'³¨\u0004×¤ÍÙ\fÓìË\u0005¨È`ÐV N´\u001e\u0005ý9\\\u001f§{³\u001d¥$4^\n½N\u0001µ\u0006OêºBÓ-Ôg>ÏÀ\u0017\u001d&éÍ\\FïÐ"), ag("0\u0003¿0\u0002§ \u0003\u0002\u0001\u0002\u0002\t\u0000ÚÃÙ\u0015sÓï0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u00000v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\f\tClockWork0\u001e\u0017\r140307220118Z\u0017\r410723220118Z0v1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00140\u0012\u0006\u0003U\u0004\n\f\u000bGoogle Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007Android1\u00120\u0010\u0006\u0003U\u0004\u0003\f\tClockWork0\u0001\"0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\u000f\u00000\u0001\n\u0002\u0001\u0001\u0000Ü\u001doK(í80\u0014²öÚÿÓ\u001dÞ{\u001ec\b@e\u000bX±e£j®¶,qS.\u0004E\t¯\u001fºO\u0018dÃ§µÖSÌ\u0000\u0015\u0000\u0010áåfú7ªÿ\u00186]®{JÝ±óÌGp¢>bþµrÁi1Z¯Nôê¥®\u001fÍÖçåêÔ1\u0013tFF\f|(û2,\\\\z¨wÃp?à·~¶ n¬krê ­!\n°*\u001fÜüvbttA©?<ê\u0016ô\"Áã2A2~ÂÉ÷01.\u001bïî)\u000bE\u001a4,¬ï[\u0014rÖÙ~ùT(ÌÕï\u0004¸Äñõ\rÒBÕ]rXfP[^K\u001b\u001eY­\u001d/ H\u0015g;ÆæC)ìÄêÔÛd©k1ÛÉ\u0007\u0002\u0003\u0001\u0000\u0001£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014G\u0010¤<³êø?«!b \u0000Î,z0\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0014G\u0010¤<³êø?«!b \u0000Î,z0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u0000\u00079b\u000b¢}*\u000fTC­\u001b`\u001c)Ù\u0001(êü?Ö(__bj>ðWæî²¬\\¢æ\u0005Ê=3õk\u00002ÄGæP\u000f%½\u0017Êù\u00039@ÈîlÜµ;íä±òHçÐ çÊê¥2ÏÚþJ¥í@@ND÷[ïÒÊÛ5¸²\u001bxF^\u0017\"òzû+\u000bn\u0015DÄ«\fOe{\u0019×}SÉÏ¹î-OE¶Tà\u0012¼éäÂâÃÓQ\u0003Ø®M,ÁÈbxW®u?\u001d{\u0002£§\u0005xÆ\u0005ã\u0005\u001cl\u001d©I\u001aÎ\u0013»Ð}}Ô&Q®¤G5\rë@^ò«óf®/ÊXÒö¿\u001d¿K\u001cHà \u0001TßÏ\u0002%\u0012õ¡Ç\"s\u001dãðGÖø")};
    static final byte[][] Ao = new byte[][]{ag("0\u0003m0\u0002W\u0002\u0006\u0001=døÖ³0\u000b\u0006\t*H÷\r\u0001\u0001\u00050|1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\u0013\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007GoogleX1\u00170\u0015\u0006\u0003U\u0004\u0003\u0013\u000eGlass Platform0\u001e\u0017\r130313181742Z\u0017\r380119031407Z0|1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\u0013\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\u0013\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\u0013\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\u0013\u0007GoogleX1\u00170\u0015\u0006\u0003U\u0004\u0003\u0013\u000eGlass Platform0\u0001\"0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\u000f\u00000\u0001\n\u0002\u0001\u0001\u0000¡3¦Òi¯Ø6ã®Ü-¤­9¿øâ\u0019æH3´\u0018µ=5lì\u0014¸GF´\u000bß\u001eB¡þôÑõ×B\fÀØ+çÚe\tÄ¯?ÛÎ/PTïìçA©éRZ\u0013#\u0003ÿÎ\u0015D¦9»ÊØt¯ ¼¼õ\u0016öYÚ7Á­/è£ÄZæ\u001eÊ¨W¢\u0005C9í¿oð@nÂA½\buqc).s©)\u0004ù=ìk½@c¼¥>y¸©Cp|¹üA;X\u000f0ðGE´õ7­§æ\u001aÿüw\u000bNÓ<><ttb\u001ez­Ôw­\u0005ÜuL\r3\rÁXõæáõ¢`<Q&¬Bô\u0018Û xF)à\r§ë\u00065ÙºGµE\fZ¢dØ/\u0002\u0003\u0001\u0000\u00010\u000b\u0006\t*H÷\r\u0001\u0001\u0005\u0003\u0001\u0001\u0000è\u0015JôØôu°ã[ðÒR\u0006c\bLÏÑr%éKþÁJ\u001f¾7ErpÀÿVöVÁPéË¹Ùl\u001c;\u000b¡æ<êõÔæ«C*Ü±\u0013Wòc´èÍ®Ð¼p}ó\u0016í.©¶VxÔMþíä/°#¯cc±NSÄB²+ø«À¿i\u0005÷ó[(\u0012Kæc\u001dF\f9_5éu«FÞ\f?ß0Ï\u000f\u0007ÙE­}Ç¨d;ICà.&[\u0010tÕùKùXìÚúªoÅ¾¨Ìfý!»²nÏeéø.µ{gìÁéx·Ú'\u0017æÖ\u001dç¦l!¿ÂY¶ÞÉ½zµòÓÛÅ\u0013\u0005ÚÚ¨ïâ)<¢\u0017:ì#\b`pNwÉÀ¦b0§"), ag("0\u0003É0\u0002± \u0003\u0002\u0001\u0002\u0002\t\u0000Ãi ­ßtÇ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u00000|1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\f\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007GoogleX1\u00170\u0015\u0006\u0003U\u0004\u0003\f\u000eGlass Platform0\u001e\u0017\r130226205628Z\u0017\r400714205628Z0|1\u000b0\t\u0006\u0003U\u0004\u0006\u0013\u0002US1\u00130\u0011\u0006\u0003U\u0004\b\f\nCalifornia1\u00160\u0014\u0006\u0003U\u0004\u0007\f\rMountain View1\u00150\u0013\u0006\u0003U\u0004\n\f\fGoogle, Inc.1\u00100\u000e\u0006\u0003U\u0004\u000b\f\u0007GoogleX1\u00170\u0015\u0006\u0003U\u0004\u0003\f\u000eGlass Platform0\u0001 0\r\u0006\t*H÷\r\u0001\u0001\u0001\u0005\u0000\u0003\u0001\r\u00000\u0001\b\u0002\u0001\u0001\u0000¯ÊGêäÐ;\u001e\bà\tw¢ø\u0006Æ¢\u0017\u001dí§[pâ:¢ñ¹¿h¥/?v,¾Æ:\bÑBZÃ\u001bé2m\u0001\u001e|\u0006Î¡ÈJëp?Ð9*1\u0006²}\u0004^|áT\u0004K\"Ê¥\u001d[õù±$â\"ºsA-ÔY0h,Fg1°Y¯¦¤èÝ?^µ@øº\u0011](G@)×\u001f1å»°ê^0 äuµ¤ý4\u0017\nÔ.ØPë9T,+éµm5þ¶²¨4iúKæ+È¤|è\u0000\u0003l®ðõ3sÉX\u0015¸ÊÙs[¿·\u0000eh¾mæw\u0010-E¿¶9z:\u001f\u0001%¸\u0015\u0005\u0005·«ÝÂ`\u001f~ñXÕ(á­;pmhE\u000f%:\u0013íyÀ\u0002l¨\u0013\u0011ÕËß·\u0002\u0001\u0003£P0N0\u001d\u0006\u0003U\u001d\u000e\u0004\u0016\u0004\u0014óSB\u001f\u000fÍ{#j_µ\u001ffWc\u0019Ð{0\u001f\u0006\u0003U\u001d#\u0004\u00180\u0016\u0014óSB\u001f\u000fÍ{#j_µ\u001ffWc\u0019Ð{0\f\u0006\u0003U\u001d\u0013\u0004\u00050\u0003\u0001\u0001ÿ0\r\u0006\t*H÷\r\u0001\u0001\u0005\u0005\u0000\u0003\u0001\u0001\u0000©X±/\u0007ï\u0014}CÅ=ÂÉèá\u0001¥b\bfF¼\u0004·\u001d÷yxÜ!/ü|\u0003ú¯Y%;èõ2Â_]uºæïº´XRp(hk\u0001B'¥A·C§³/4Ñ[Yô \u0015X%ý¼ì>ÒtÎìÇ\u0001Ë«[Ug\"3wn÷ä´â\u0001R\u000eFÕEI\\\u0014Ày­}\u001fýã¢±Ê\u001bQ[ +7[÷/6\u000fó-­`S:Ú×Å~#dRE¥ºÊÊBTý!³d!_\u0004vòéI\u0019÷W \u0013Xv\nF!î\u0003UÙ»@h\u000fÚó±¨f\u0004+Ë@3àw,Öãª\u001e Æñ\u0002\u0004úå[£áÙßëÔ@Uü\u0007¨æ­;Ô\u00117ö/_f£÷\u0018$õO({Úø?")};
    private static final byte[][] Ap = m109a(Aj, Ak, Al, Am, An, Ao);
    private static final byte[][] Aq = new byte[][]{Aj[0], Ak[0], Am[0], An[0], Ao[0]};
    public static boolean Ar = false;
    public static boolean As = false;
    private static int At = -1;
    private static final Object Au = new Object();
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 4452000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    /* renamed from: a */
    public static boolean m106a(PackageManager packageManager, PackageInfo packageInfo) {
        boolean z = true;
        boolean z2 = false;
        if (packageInfo == null) {
            return false;
        }
        if (m115c(packageManager)) {
            if (m108a(packageInfo, Ap) == null) {
                z = false;
            }
            return z;
        }
        if (m108a(packageInfo, Aq) != null) {
            z2 = true;
        }
        if (z2 || m108a(packageInfo, Ap) == null) {
            return z2;
        }
        Log.w("GooglePlayServicesUtil", "Test-keys aren't accepted on this build.");
        return z2;
    }

    /* renamed from: a */
    public static boolean m107a(Resources resources) {
        if (resources == null) {
            return false;
        }
        return (gr.fu() && ((resources.getConfiguration().screenLayout & 15) > 3)) || m113b(resources);
    }

    /* renamed from: a */
    private static byte[] m108a(PackageInfo packageInfo, byte[]... bArr) {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X509");
            if (packageInfo.signatures.length != 1) {
                Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
                return null;
            }
            try {
                try {
                    ((X509Certificate) instance.generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).checkValidity();
                    byte[] toByteArray = packageInfo.signatures[0].toByteArray();
                    for (byte[] bArr2 : bArr) {
                        if (Arrays.equals(bArr2, toByteArray)) {
                            return bArr2;
                        }
                    }
                    if (Log.isLoggable("GooglePlayServicesUtil", 2)) {
                        Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(toByteArray, 0));
                    }
                    return null;
                } catch (CertificateExpiredException e) {
                    Log.w("GooglePlayServicesUtil", "Certificate has expired.");
                    return null;
                } catch (CertificateNotYetValidException e2) {
                    Log.w("GooglePlayServicesUtil", "Certificate is not yet valid.");
                    return null;
                }
            } catch (CertificateException e3) {
                Log.w("GooglePlayServicesUtil", "Could not generate certificate.");
                return null;
            }
        } catch (CertificateException e4) {
            Log.w("GooglePlayServicesUtil", "Could not get certificate instance.");
            return null;
        }
    }

    /* renamed from: a */
    private static byte[][] m109a(byte[][]... bArr) {
        int i = 0;
        for (byte[][] length : bArr) {
            i += length.length;
        }
        byte[][] bArr2 = new byte[i][];
        int length2 = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            byte[][] bArr3 = bArr[i2];
            i = i3;
            i3 = 0;
            while (i3 < bArr3.length) {
                int i4 = i + 1;
                bArr2[i] = bArr3[i3];
                i3++;
                i = i4;
            }
            i2++;
            i3 = i;
        }
        return bArr2;
    }

    private static byte[] ag(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b */
    public static Intent m110b(Context context, int i) {
        switch (i) {
            case 1:
            case 2:
                return fi.ao(GOOGLE_PLAY_SERVICES_PACKAGE);
            case 3:
                return fi.am(GOOGLE_PLAY_SERVICES_PACKAGE);
            case 12:
                return fi.eS();
            default:
                return null;
        }
    }

    /* renamed from: b */
    public static boolean m111b(PackageManager packageManager) {
        synchronized (Au) {
            if (At == -1) {
                try {
                    if (m108a(packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64), Ap[1]) != null) {
                        At = 1;
                    } else {
                        At = 0;
                    }
                } catch (NameNotFoundException e) {
                    At = 0;
                }
            }
        }
        return At != 0;
    }

    /* renamed from: b */
    public static boolean m112b(PackageManager packageManager, String str) {
        try {
            return m106a(packageManager, packageManager.getPackageInfo(str, 64));
        } catch (NameNotFoundException e) {
            if (Log.isLoggable("GooglePlayServicesUtil", 3)) {
                Log.d("GooglePlayServicesUtil", "Package manager can't find package " + str + ", defaulting to false");
            }
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m113b(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        return gr.fw() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
    }

    /* renamed from: c */
    public static String m114c(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return m107a(context.getResources()) ? resources.getString(C0076R.string.common_google_play_services_install_text_tablet) : resources.getString(C0076R.string.common_google_play_services_install_text_phone);
            case 2:
                return resources.getString(C0076R.string.common_google_play_services_update_text);
            case 3:
                return resources.getString(C0076R.string.common_google_play_services_enable_text);
            case 5:
                return resources.getString(C0076R.string.common_google_play_services_invalid_account_text);
            case 7:
                return resources.getString(C0076R.string.common_google_play_services_network_error_text);
            case 9:
                return resources.getString(C0076R.string.common_google_play_services_unsupported_text);
            case 12:
                return resources.getString(C0076R.string.common_google_play_services_unsupported_date_text);
            default:
                return resources.getString(C0076R.string.common_google_play_services_unknown_issue);
        }
    }

    /* renamed from: c */
    public static boolean m115c(PackageManager packageManager) {
        return m111b(packageManager) || !dX();
    }

    /* renamed from: d */
    public static String m116d(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0076R.string.common_google_play_services_install_button);
            case 2:
                return resources.getString(C0076R.string.common_google_play_services_update_button);
            case 3:
                return resources.getString(C0076R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }

    public static boolean dX() {
        return Ar ? As : "user".equals(Build.TYPE);
    }

    /* renamed from: e */
    public static String m117e(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0076R.string.f100x8f024ee1);
            case 2:
                return resources.getString(C0076R.string.common_google_play_services_notification_needs_update_title);
            case 3:
                return resources.getString(C0076R.string.common_google_play_services_needs_enabling_title);
            case 5:
                return resources.getString(C0076R.string.common_google_play_services_invalid_account_text);
            case 7:
                return resources.getString(C0076R.string.common_google_play_services_network_error_text);
            case 9:
                return resources.getString(C0076R.string.common_google_play_services_unsupported_text);
            case 12:
                return resources.getString(C0076R.string.common_google_play_services_unsupported_date_text);
            default:
                return resources.getString(C0076R.string.common_google_play_services_unknown_issue);
        }
    }

    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode) {
        return getErrorDialog(errorCode, activity, requestCode, null);
    }

    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
        Builder message = new Builder(activity).setMessage(m114c(activity, errorCode));
        if (cancelListener != null) {
            message.setOnCancelListener(cancelListener);
        }
        OnClickListener fdVar = new fd(activity, m110b((Context) activity, errorCode), requestCode);
        CharSequence d = m116d(activity, errorCode);
        if (d != null) {
            message.setPositiveButton(d, fdVar);
        }
        switch (errorCode) {
            case 0:
                return null;
            case 1:
                return message.setTitle(C0076R.string.common_google_play_services_install_title).create();
            case 2:
                return message.setTitle(C0076R.string.common_google_play_services_update_title).create();
            case 3:
                return message.setTitle(C0076R.string.common_google_play_services_enable_title).create();
            case 4:
            case 6:
                return message.create();
            case 5:
                Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
                return message.setTitle(C0076R.string.common_google_play_services_invalid_account_title).create();
            case 7:
                Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
                return message.setTitle(C0076R.string.common_google_play_services_network_error_title).create();
            case 8:
                Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
                return message.create();
            case 9:
                Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
                return message.setTitle(C0076R.string.common_google_play_services_unsupported_title).create();
            case 10:
                Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
                return message.create();
            case 11:
                Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
                return message.create();
            case 12:
                Log.e("GooglePlayServicesUtil", "The date of the device is not valid.");
                return message.setTitle(C0076R.string.common_google_play_services_unsupported_title).create();
            default:
                Log.e("GooglePlayServicesUtil", "Unexpected error code " + errorCode);
                return message.create();
        }
    }

    public static PendingIntent getErrorPendingIntent(int errorCode, Context context, int requestCode) {
        Intent b = m110b(context, errorCode);
        return b == null ? null : PendingIntent.getActivity(context, requestCode, b, DriveFile.MODE_READ_ONLY);
    }

    public static String getErrorString(int errorCode) {
        switch (errorCode) {
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 12:
                return "DATE_INVALID";
            default:
                return "UNKNOWN_ERROR_CODE";
        }
    }

    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Uri.Builder().scheme("android.resource").authority(GOOGLE_PLAY_SERVICES_PACKAGE).appendPath("raw").appendPath("oss_notice").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream == null) {
                return next;
            }
            openInputStream.close();
            return next;
        } catch (NoSuchElementException e) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Exception e2) {
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext(GOOGLE_PLAY_SERVICES_PACKAGE, 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(GOOGLE_PLAY_SERVICES_PACKAGE);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static int isGooglePlayServicesAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C0076R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (System.currentTimeMillis() < 1227312000288L) {
            return 12;
        }
        m119t(context);
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64);
            if (!gk.m1035y(context)) {
                try {
                    if (m108a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 64), Aj) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (m108a(packageInfo, m108a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 64), Aj)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                    return 9;
                }
            } else if (m108a(packageInfo, Aj) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (packageInfo.versionCode < GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires 4452000 but found " + packageInfo.versionCode);
                return 2;
            }
            try {
                return !packageManager.getApplicationInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 0).enabled ? 3 : 0;
            } catch (NameNotFoundException e2) {
                Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                e2.printStackTrace();
                return 1;
            }
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    public static boolean isUserRecoverableError(int errorCode) {
        switch (errorCode) {
            case 1:
            case 2:
            case 3:
            case 9:
            case 12:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: s */
    public static void m118s(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            Intent b = m110b(context, isGooglePlayServicesAvailable);
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + isGooglePlayServicesAvailable);
            if (b == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", b);
        }
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode) {
        return showErrorDialogFragment(errorCode, activity, requestCode, null);
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
        boolean z = false;
        Dialog errorDialog = getErrorDialog(errorCode, activity, requestCode, cancelListener);
        if (errorDialog == null) {
            return z;
        }
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
        }
        if (z) {
            SupportErrorDialogFragment.newInstance(errorDialog, cancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), GMS_ERROR_DIALOG);
        } else if (gr.fu()) {
            ErrorDialogFragment.newInstance(errorDialog, cancelListener).show(activity.getFragmentManager(), GMS_ERROR_DIALOG);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
        return true;
    }

    public static void showErrorNotification(int errorCode, Context context) {
        Resources resources = context.getResources();
        Notification notification = new Notification(17301642, resources.getString(C0076R.string.common_google_play_services_notification_ticker), System.currentTimeMillis());
        notification.flags |= 16;
        CharSequence e = m117e(context, errorCode);
        String u = m120u(context);
        notification.setLatestEventInfo(context, e, resources.getString(C0076R.string.common_google_play_services_error_notification_requested_by_msg, new Object[]{u}), getErrorPendingIntent(errorCode, context, 0));
        ((NotificationManager) context.getSystemService("notification")).notify(39789, notification);
    }

    /* renamed from: t */
    private static void m119t(Context context) {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (Throwable e) {
            Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.version");
            if (i != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected 4452000 but found " + i + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
            return;
        }
        throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
    }

    /* renamed from: u */
    private static String m120u(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }
}
