/*
 * Copyright 2014 Alexander Chauncey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.censoredsoftware.infractions.bukkit.legacy.data;

import com.google.common.base.Supplier;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TempDataManager {
    // -- TEMP DATA -- //

    // Temp Data
    static final Table<String, String, Object> TEMP = Tables.newCustomTable(new ConcurrentHashMap<String, Map<String, Object>>(), new Supplier<ConcurrentHashMap<String, Object>>() {
        @Override
        public ConcurrentHashMap<String, Object> get() {
            return new ConcurrentHashMap<String, Object>();
        }
    });

    public static boolean exists(String row, String column) {
        return TEMP.contains(row, column);
    }

    public static Object get(String row, String column) {
        if (exists(row, column)) return TEMP.get(row, column);
        else return null;
    }

    public static void put(String row, String column, Object value) {
        TEMP.put(row, column, value);
    }

    public static void remove(String row, String column) {
        if (exists(row, column)) TEMP.remove(row, column);
    }

    public static void purge() {
        TEMP.clear();
    }
}
