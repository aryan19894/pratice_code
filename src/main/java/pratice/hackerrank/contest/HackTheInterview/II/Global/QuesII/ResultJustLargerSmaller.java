package pratice.hackerrank.contest.HackTheInterview.II.Global.QuesII;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultJustLargerSmaller {
    public static List<Integer> getMaxCharCount1(String s, List<List<Integer>> queries) {
        List<Integer> r = new ArrayList();
        s = s.toLowerCase();
        Iterator var3 = queries.iterator();

        while(true) {
            while(var3.hasNext()) {
                List<Integer> q = (List)var3.next();
                int st = (Integer)q.get(0);
                int en = (Integer)q.get(1);
                if (en - st == 1) {
                    if (s.charAt(st) == s.charAt(en)) {
                        r.add(2);
                    } else {
                        r.add(1);
                    }
                } else if (st == en) {
                    r.add(1);
                } else {
                    String subString = s.substring(st, en + 1);
                    int count = 0;

                    for(int i = 26; i >= 0; --i) {
                        char ch = (char)(i + 96);
                        String regex = "[" + ch + "]";
                        Pattern p = Pattern.compile(regex);

                        for(Matcher m = p.matcher(subString); m.find(); ++count) {
                        }

                        if (count > 0) {
                            break;
                        }
                    }

                    r.add(count);
                }
            }

            return r;
        }
    }

    public static List<Integer> getMaxCharCount2(String s, List<List<Integer>> queries) {
        List<Integer> r = new ArrayList();
        Map<Character, List<Integer>> f = new HashMap();
        s = s.toLowerCase();
        char[] ch = s.toCharArray();

        List l;
        for (int i = 0; i < s.length(); ++i) {
            f.putIfAbsent(ch[i], new ArrayList());
            l = (List) f.get(ch[i]);
            l.add(i);
        }

        Iterator var13 = queries.iterator();

        while(var13.hasNext()) {
            l = (List) var13.next();
            int st = (Integer) l.get(0);
            int en = (Integer) l.get(1);
            if (en - st == 1) {
                if (s.charAt(st) == s.charAt(en)) {
                    r.add(2);
                } else {
                    r.add(1);
                }
            } else if (st == en) {
                r.add(1);
            } else if (f.size() == 1) {
                r.add(en - st + 1);
            } else {
                String subString = s.substring(st, en + 1);
                char[] subChar = subString.toCharArray();
                sort(subChar, 0, subChar.length - 1);
                char maxChar = subChar[subChar.length - 1];
                List<Integer> list = (List)f.get(maxChar);
                if (list.size() == 1) {
                    r.add(1);
                } else {
                    r.add(justSmaller(list, en) - justLarger(list, st) + 1);
                }
            }
        }

        return r;
    }

    private static void sort(char[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }

    }

    static void merge(char[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        char[] L = new char[n1];
        char[] R = new char[n2];

        int i;
        for(i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }

        for(i = 0; i < n2; ++i) {
            R[i] = arr[m + 1 + i];
        }

        i = 0;
        int j = 0;

        int k;
        for(k = l; i < n1 && j < n2; ++k) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                ++i;
            } else {
                arr[k] = R[j];
                ++j;
            }
        }

        while(i < n1) {
            arr[k] = L[i];
            ++i;
            ++k;
        }

        while(j < n2) {
            arr[k] = R[j];
            ++j;
            ++k;
        }

    }

    private static int justLarger(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        int ans = start;

        while(start <= end) {
            int mid = (start + end) / 2;
            if ((Integer)list.get(mid) == target) {
                ans = mid;
                break;
            }

            if ((Integer)list.get(mid) < target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }

    private static int justSmaller(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        int ans = end;

        while(start <= end) {
            int mid = (start + end) / 2;
            if ((Integer)list.get(mid) == target) {
                ans = mid;
                break;
            }

            if ((Integer)list.get(mid) > target) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }

        return ans;
    }

}
