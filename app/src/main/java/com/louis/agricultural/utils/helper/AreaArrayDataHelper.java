package com.louis.agricultural.utils.helper;

import android.content.Context;

import com.google.gson.Gson;
import com.louis.agricultural.model.entities.AreaEntity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 0.1 king 2015-11
 */
public class AreaArrayDataHelper {

    private static final Map<String, Map<String, List<String>>> DATAs = new LinkedHashMap<>();

    private static void init(Context context) {
        if (!DATAs.isEmpty()) {
            return;
        }

        String json = getFromAssets("area.json", context);
        Gson gson = new Gson();
        AreaEntity areaEntity = gson.fromJson(json, AreaEntity.class);
        List<AreaEntity.ProvinceEntity> provinces = areaEntity.getProvince();

        for (int i = 0; i < provinces.size(); i++) {
            Map<String, List<String>> cityMap = new HashMap<>();
            AreaEntity.ProvinceEntity provinceEntity = provinces.get(i);
            List<AreaEntity.ProvinceEntity.CityEntity> citys = provinceEntity.getCity();
            for (int j = 0; j < citys.size(); j++) {
                cityMap.put(citys.get(j).getName(), citys.get(j).getArea());
            }
            DATAs.put(provinces.get(i).getName(), cityMap);
        }

    }

    public static Map<String, Map<String, List<String>>> getAll(Context context) {
        init(context);
        return new HashMap<>(DATAs);
    }

    public static String getFromAssets(String fileName, Context context) {
        try {
            InputStreamReader inputReader = new InputStreamReader(context
                    .getResources().getAssets().open(fileName));

            BufferedReader bufReader = new BufferedReader(inputReader);

            String line = "";
            String result = "";
            while ((line = bufReader.readLine()) != null) {
                result += line;
            }
            return result;
        } catch (Exception e) {
        }
        return "";
    }

}
