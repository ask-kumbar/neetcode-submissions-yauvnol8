class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        int n = 0;
        for (List<String> equ : equations) {
            if(!map.containsKey(equ.get(0))) {
                map.put(equ.get(0), n);
                n++;
            }
            if(!map.containsKey(equ.get(1))) {
                map.put(equ.get(1), n);
                n++;
            }
        }

        double[][] linkCost = new double[n][n];
        int i = 0;
        for (List<String> equ : equations) {
            int indexA = map.get(equ.get(0));
            int indexB = map.get(equ.get(1));
            linkCost[indexA][indexB] = values[i];
            linkCost[indexB][indexA] = 1/values[i];
            i++;
        }
        for (int j = 0; j < n; j++) {
            linkCost[j][j] = 1;
        }


        double[] result = new double[queries.size()];
        i = 0;
        boolean[] visit = new boolean[n];
        for (List<String> query : queries) {
            Arrays.fill(visit, false);
            if(!map.containsKey(query.get(0)) || !map.containsKey(query.get(1))) {

                result[i] = -1;
            }
            else {
                result[i] = dfs(map.get(query.get(0)), map.get(query.get(1)), linkCost, visit);
                // if (result[i] == -1) {
                //      Arrays.fill(visit, false);
                //      result[i] = dfs(map.get(query.get(1)), map.get(query.get(0)), linkCost, visit);
                // }
            }
            i++;
        }
        return result;

    }

    public double dfs(int s, int e, double[][] linkCost, boolean[] visit) {
        visit[s] = true;
        if (linkCost[s][e] != 0) {
            return linkCost[s][e];
        }
        if (s == e) {
            return -1;
        }
        for (int i = 0; i < visit.length; i++) {

            if (visit[i] != true ) {
                if(linkCost[s][i] != 0) {
                    double val = this.dfs(i, e, linkCost, visit);
                    if( val != -1 ) {
                        return val * linkCost[s][i] ;
                    }
                }
            }
        }
        return -1.0;
    }

}