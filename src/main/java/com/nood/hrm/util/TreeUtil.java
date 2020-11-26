package com.nood.hrm.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nood.hrm.model.Permission;

import java.util.List;

public class TreeUtil {

    /**
     * 菜单树
     *
     * @param parentId
     * @param allPermission
     * @param array
     */
    public static void setPermissionsTree(Integer parentId, List<Permission> allPermission, JSONArray array) {

        for (Permission current : allPermission) {
            if (current.getParentId().equals(parentId)) {

                String string = JSONObject.toJSONString(current);
                JSONObject parent = (JSONObject) JSONObject.parse(string);
                array.add(parent);

                if (allPermission.stream().filter(p -> p.getParentId().equals(current.getId())).findAny() != null) {
                    JSONArray child = new JSONArray();
                    parent.put("child", child);
                    setPermissionsTree(current.getId(), allPermission, child);
                }

            }
        }

    }
}
