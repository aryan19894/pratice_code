package com.hackerrank.contest.HackTheInterview.II.Global.QuesII;

import java.util.*;

public class Result {
    public static List<Integer> getMaxCharCount1(String s, List<List<Integer>> queries) {
        List<Integer> r = new ArrayList();
        s = s.toLowerCase();
        Iterator var4 = queries.iterator();

        while (var4.hasNext()) {
            List<Integer> i = (List) var4.next();
            int st = (Integer) i.get(0);
            int en = (Integer) i.get(1);
            char max = s.charAt(st);

            int[] fr = null;
            for (fr = new int[26]; st <= en; ++st) {
                char ch = s.charAt(st);
                ++fr[ch - 97];
                max = (char) Math.max(max, ch);
            }

            r.add(fr[max - 97] != 0 ? fr[max - 97] : 1);
        }

        return r;
    }

    public static List<Integer> getMaxCharCount2(String s, List<List<Integer>> queries) {
        List<Integer> r = new ArrayList();
        SortedMap<Character, List<Integer>> f = new TreeMap(Collections.reverseOrder());
        s = s.toLowerCase();
        char[] ch = s.toCharArray();

        List l;
        for (int i = 0; i < s.length(); ++i) {
            f.putIfAbsent(ch[i], new ArrayList());
            l = (List) f.get(ch[i]);
            l.add(i);
        }

        Iterator var18 = queries.iterator();

        while (true) {
            while (var18.hasNext()) {
                l = (List) var18.next();
                int st = (Integer) l.get(0);
                int en = (Integer) l.get(1);
                int freq = 0;
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
                    Iterator var10 = f.values().iterator();

                    while (var10.hasNext()) {
                        List<Integer> in = (List) var10.next();
                        int firstIndex = 0;
                        int lastIndex = in.size() - 1;
                        int min = (Integer) in.get(firstIndex);
                        int max = (Integer) in.get(lastIndex);
                        int k;
                        int comp;
                        if (in.size() > 3) {
                            k = (Integer) in.get(lastIndex / 2);
                            comp = (Integer) in.get(lastIndex / 2 + 1);
                            if (min <= en && st <= k) {
                                lastIndex /= 2;
                            } else {
                                if (comp > en || st > max) {
                                    continue;
                                }

                                firstIndex = lastIndex / 2 + 1;
                                lastIndex = in.size() - 1;
                            }
                        }

                        for (k = firstIndex; k <= lastIndex; ++k) {
                            comp = (Integer) in.get(k);
                            if (st <= comp && comp <= en) {
                                ++freq;
                            }
                        }

                        if (freq != 0) {
                            break;
                        }
                    }

                    r.add(freq);
                }
            }

            return r;
        }
    }

    public static List<Integer> getMaxCharCount3(String s, List<List<Integer>> queries) {
        List<Integer> r = new ArrayList();
        s = s.toLowerCase();
        Iterator var3 = queries.iterator();

        while (true) {
            while (var3.hasNext()) {
                List<Integer> q = (List) var3.next();
                int st = (Integer) q.get(0);
                int en = (Integer) q.get(1);
                if (en - st == 1) {
                    if (s.charAt(st) == s.charAt(en)) {
                        r.add(2);
                    } else {
                        r.add(1);
                    }
                } else if (st == en) {
                    r.add(1);
                } else {
                    char max = s.charAt(st);
                    int freq = 1;

                    for (int i = st + 1; i <= en; ++i) {
                        char current = s.charAt(i);
                        if (max == current) {
                            ++freq;
                        } else if (max < current) {
                            freq = 1;
                            max = current;
                        }
                    }

                    r.add(freq);
                }
            }

            return r;
        }
    }

    public static List<Integer> getMaxCharCount4(String s, List<List<Integer>> queries) {
        List<Integer> r = new ArrayList();
        SortedMap<Character, List<Integer>> f = new TreeMap(Collections.reverseOrder());
        s = s.toLowerCase();
        char[] ch = s.toCharArray();

        List l;
        for (int i = 0; i < s.length(); ++i) {
            f.putIfAbsent(ch[i], new ArrayList());
            l = (List) f.get(ch[i]);
            l.add(i);
        }

        Iterator var18 = queries.iterator();

        while (true) {
            while (var18.hasNext()) {
                l = (List) var18.next();
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
                    String newStr = String.valueOf(Arrays.copyOfRange(ch, st, en + 1));
                    Iterator var10 = f.entrySet().iterator();

                    while (var10.hasNext()) {
                        Map.Entry<Character, List<Integer>> entry = (Map.Entry) var10.next();
                        if (newStr.contains("" + entry.getKey())) {
                            int listSize = ((List) entry.getValue()).size();
                            int justStartIndex = 0;
                            int justEndIndex = listSize - 1;
                            if (listSize == 1) {
                                r.add(1);
                                break;
                            }

                            List<Integer> list = (List) entry.getValue();
                            Iterator var16 = list.iterator();

                            while (var16.hasNext()) {
                                Integer d = (Integer) var16.next();
                                if (st <= d) {
                                    justStartIndex = list.indexOf(d);
                                    break;
                                }
                            }

                            for (int k = listSize - 1; k >= justStartIndex; --k) {
                                if (en >= (Integer) list.get(k)) {
                                    justEndIndex = k;
                                    break;
                                }
                            }

                            r.add(justEndIndex - justStartIndex + 1);
                            break;
                        }
                    }
                }
            }

            return r;
        }
    }

    public static List<Integer> getMaxCharCount5(String s, List<List<Integer>> queries) {
        List<Integer> res = new ArrayList();
        int len = s.length();
        String sc = new String(s.toLowerCase());
        int[][] freqs = new int[len][26];
        freqs[0][sc.charAt(0) - 97] = 1;

        for (int i = 1; i < len; ++i) {
            copyArray(i, freqs);
            sc.charAt(i);
            String str = i + "," + (sc.charAt(i) - 97);
            int var10002 = freqs[i][sc.charAt(i) - 97]++;
        }

        Iterator var12 = queries.iterator();

        while (true) {
            while (true) {
                while (var12.hasNext()) {
                    List<Integer> query = (List) var12.next();
                    int right = (Integer) query.get(1);
                    int left = (Integer) query.get(0);
                    int i;
                    if (left == 0) {
                        for (i = 25; i >= 0; --i) {
                            if (freqs[right][i] > 0) {
                                res.add(freqs[right][i]);
                                break;
                            }
                        }
                    } else {
                        for (i = 25; i >= 0; --i) {
                            (new StringBuilder()).append(right).append(",").append(i).append("-").append(left - 1).append(",").append(i).toString();
                            if (freqs[right][i] - freqs[left - 1][i] > 0) {
                                res.add(freqs[right][i] - freqs[left - 1][i]);
                                break;
                            }
                        }
                    }
                }

                return res;
            }
        }
    }

    public static void copyArray(int idx, int[][] freqs) {
        for (int i = 0; i < 26; ++i) {
            (new StringBuilder()).append(idx).append(",").append(i).append("=").append(idx - 1).append(",").append(i).toString();
            freqs[idx][i] = freqs[idx - 1][i];
        }

    }
}
