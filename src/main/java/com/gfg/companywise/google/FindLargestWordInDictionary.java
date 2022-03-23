package com.gfg.companywise.google;

import com.common.Out;
import com.common.converter.Array;

import java.util.List;

public class FindLargestWordInDictionary {
    static String findLongestWord(String S, List<String> d) {
        String result = "";
        int len = 0;
        for (String word : d) {
            if (len <= word.length() && isSubSequence(S, word)) {
                result = max(result, word);
                len = word.length();
            }
        }
        return result;
    }

    private static String max(String larger, String lcs) {
        if (larger.length() > lcs.length()) return larger;
        else if (larger.length() < lcs.length()) return lcs;
        else return larger.compareTo(lcs) < 0 ? larger : lcs;
    }

    private static boolean isSubSequence(String s, String w) {
        int n = s.length(), m = w.length();
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            if (s.charAt(i) == w.charAt(j)) j++;
        }
        return (j == m);
    }

    public static void main(String[] args) {
        String S = "ssnipuulhuggnltpdroupyhuvyodwprsuvcemfooqpdjbglzmztwsyjcvrylhxepudbxr";
        String[] dict = {"bzejhazmtluquyucodsandqblfusdh", "kyvhbmldtainllnkjloeirfsgexeewieqcvxsqloqcuecfg", "yrggdwomyjlibbtctcxcdihyebmjzbirjndfeiwwnfnxpqhungjyimbxdblczeeywgskkelgvbipmcviznxlgtudjvjychie", "zqgdtbfbxocmvludsjpvwfxwpblklypgtzvvrtqycvidquffwni", "vjrahevicpcmbdwhhyvgdwxicppavrhnyqkopeonzcbslhpvrrfddyteneojfdytompvum", "zlrsbcljlasaordsdcpagopxbkril", "fimxxbrbbkjuwqhajzvzhphwuywaxleytdowzocpfjqydfk", "vpdvhdaojxkcayggrbnnvvrvujutbteddehgkexacmpbmpwtazstsyoemy", "oujpjrhbhgmqbznutjtdkqriyfenngvrkthljnmkzbozgwyffnsfwhhxzglxblwynken", "m", "awpukusghmlkyggnvtdhcbsmxohjuixctrhffarfejisaqyddpnpvxjrxfxaqxovckxoapdguzhqmdqmlczxugmkpsbbny", "ddyptpqzouiwiyzkeptobfxluxazyjymmdbfegwwjinxoodyespnjfzwah", "onthyduagsgxa", "nyrdtpsnofgaqjprubhxndnfwsowgwwnlqrnzizptsjauryrescltthewwpgvtglabecldxjwmhkierfhrvhulnmulhjngrcny", "pmemiskjucwwbaedkymxnqydhssqmcgdqfggzdh", "vygiknzxcihezpmkmtgzsvvnxspghtcucnkcytpcjgppxfrxaqkharqiypoaegupvonbemoptghyfeqyhfhj", "zrqbyvefuccwzmnaeyselegefujhxfmoytqlvtsmebukqycpartfzfocvkvbvvuyiyrfedpxdfifhwntmwrglkhesrxthnp", "dlkhxmemjzoaqsjvvnvepsdwegnafquxlllktrubcrohxnaj", "zdktyykjcaddbidcpvinzryvxdbmdliuisqonbnftzelqbqzeetflrxsiuqsdtkrxdigizhgmsteossuhpjltjetrqicleperm", "hgdlkpgwzlufhrjwiyoexuecfaxvhjuesgrbrxojkajaswgekxwzcjwetxxansk", "xsjkncyzxrawgzpyzdmrclytdgylmxkauhlmubvaxvurlbmikxrgiepbhubwwtfnmlpnbz", "vcrpkppaffepclzixdjbmsywjnjdmletkicvxlkoeyzrdld", "rkqqlizdamhncsvwaorvkevwpykszuvxxgfqexqcgnvpjmcqxmtajstlqzwkpiuffxbujhzovinxiaac", "wbrqtgirwyqlrpnjtzpuelqvowsvedjhhrpfar", "uzddbwdkadaesxxdhvondseebbscqnezqgctwcudbitsdkpdvotpmiehcftqvkprnoegchlyegkhgfbwczictp", "uvzryondptdsplbywohwdljkutifkbmlwgfddcplxohnvhnbttpd", "vzqjgarsebvysimxrhnuwtcpxppspjyiyawvpdtrvuheycdvpxzldsrhtdvooylayhfsep", "emzqjnaookpktxvlxr", "rtcdjexbqefjrxcfdaauoqovenqklpkslgqjzvhrqlvpombrjzjkjwiygrkxapqdyjernjvugcrjyppvjkltrtrhllpgpvl", "evtsypujvaximmabcoajjbvlesibzpdlsrrxyvyqnum", "vpohtgqqqbllslvtjriprxhnqimzrikisobctbrptlpwwmmernbqkqtourceyxzjojjssexojqnzbwnyehjk", "fbcpmymltliwcrttfarghzjemwjwzawisagykympoavdmzqzaalbulxdykoxfjmzgbaukwapyhlawvyzypybgxlvpgcyiqhzg", "secheieijvblxyeztghozysiqyhfzbuevmeviloqbnrzpfbdgwmom", "prvjcgufjrntsrryusnwgrmtl", "dwcigwqtynmbfbrrdfoe", "mfwicnnc", "knzxklthmgmtklkormtcxayfmwmppjbbgtsdqvkzeomlowjvacnxqvzjhirrpffunlkwuaxzbhjqjlbiqtitgxhrbisphe", "azicvownveljnvaklibgfsmwelbwsvuklptlsknebxzchtgefyprewvcmvketddbqkeby", "mqoyjpfcfmurdeiqjfqhjaevreclokctlqruwkoknixkwjpgskqybgupumdanyhgdmtcrrbifxfhhqojfulnqoexxvqyjzwwy", "fiwdctknnpkmvwkeddogfxxlb", "ym", "lxtnhpwmzoogfrctcxrrnxoyvohtnwqvxwld", "pjjhabhjkotxelqvtqtobnisxzqtyocbfij", "uaxahggbdktdvmqzsxdnpnlgvbovvbjkwqcjzudlfujibgejrnfibxchwe", "ccjunudlksiguefsnuknomompztmcvs", "dy", "qigfusayoabklezqyephgvvxyphlqzhdzesxfxvek", "jagwcwaewoqlfkluwzggjasbcdxshwdlycjsvzedhtcpnsmnuprbahjcmvbiocvaymtgw", "tsbelczblezfczcpnodajvaekfdsnbdbyvikgdxifrhefmjquypwbevrigplsirufupiceeqzqmybop", "qmmpyjzmvklddfqelrlkathwstklubfvtkqmsdftyooykbhvoquirludkrmgtwfmxkftyvleqhulhaclinekwkmgvtsfhfyyj", "jbtejit", "ycptimagovkedgjswkvktbiqewmmdxqxsgodhlvfhdxzlqmueuusejudlk", "xbhfpopruxrukraucmtlesimrvqsmuoemhisumrzjtgyyjfebyzwcqhqspfwmgupijptfezcczabefxqv", "uquqbriibsxdnvealyaxpcskfnfvsbzqkowuieptukautzccscczwcc", "mkjhscejmhdtequumuvksrhoghvpuirwrzm", "jayyvapntsyc", "xifxxewjaosvxjayehxnazdpomhzrslkzzimgn", "cuakewouyvhxutpecodc", "icdhcrjdnmyqxdpntqkamnocfklaftbuauogkwilmqpxtkxwuxiccvoblcumrabtrfryqwcsxsxpg", "qcxlbazzxnwaokvpgfasiwbwhalykmwbylqzfloffyjnlcxcdkusmomvjuynqccqtpegznzfkhlqlzb", "rqmxrssfwsdyksmywznrpcjzszkrvwmykqhtkizlojzmu", "njrneqwuhobmvlhlvqxfualabqqzzhyhxjskxxoyqpgamgaisryjykqete", "yohwaathwuhltlfaokppiekbkvlikppfrhcqnvienyfytbipqvlmjhggtsxwycivmjwfqfvhcwwrihlqqmqubgfksvwa", "hoxoehp", "quaf", "hrwxxpqkxjepbbd", "wbytshvzghb", "jyiasyw", "mkncaidnnqocahl", "brpgkzcochoxftilwlgjehpbctqkfgyhzvptamzskoqlbgwpyy", "nkagfktkyowzgkclzkqstxsfdbtbpjyqtoleakcmah", "isncrnepxmjtkkjiacrdjmdgzgtm", "votyqxuarblzslhengxvzhwbryzwezqgdqinabmirizmaypej", "vejkgnfvgrintbnaunvfb", "ss"};
//        String S = "abpcplea";
        //String[] dict = {"zwusqtplmwcbqtupncijki"};
        List<String> d = Array.toList(dict);
        Out.print(findLongestWord(S, d));
    }
}
