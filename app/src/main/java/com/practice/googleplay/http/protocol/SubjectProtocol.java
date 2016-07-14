package com.practice.googleplay.http.protocol;

import com.practice.googleplay.domain.SubjectInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 专题网络请求
 *
 */
public class SubjectProtocol extends BaseProtocol<ArrayList<SubjectInfo>> {

	@Override
	public String getKey() {
		return "subject";
	}

	@Override
	public String getParams() {
		return "";
	}

	@Override
	public ArrayList<SubjectInfo> parseData(String result) {
		try {
			JSONArray ja = new JSONArray(result);

			ArrayList<SubjectInfo> list = new ArrayList<SubjectInfo>();
			for (int i = 0; i < ja.length(); i++) {
				JSONObject jo = ja.getJSONObject(i);

				SubjectInfo info = new SubjectInfo();
				info.des = jo.getString("des");
				info.url = jo.getString("url");

				list.add(info);
			}

			return list;
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

}
