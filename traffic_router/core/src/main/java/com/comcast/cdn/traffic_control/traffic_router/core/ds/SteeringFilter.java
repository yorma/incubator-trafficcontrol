/*
 * Copyright 2016 Comcast Cable Communications Management, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.comcast.cdn.traffic_control.traffic_router.core.ds;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.regex.Pattern;

public class SteeringFilter {
	@JsonProperty
	private String pattern;
	@JsonProperty
	private String deliveryService;

	private Pattern patternRegex;

	public String getPattern() {
		return pattern;
	}

	public void setPattern(final String pattern) {
		this.pattern = pattern;
		patternRegex = Pattern.compile(pattern);
	}

	public String getDeliveryService() {
		return deliveryService;
	}

	public void setDeliveryService(final String deliveryService) {
		this.deliveryService = deliveryService;
	}

	public boolean matches(final String s) {
		return patternRegex.matcher(s).matches();
	}

	@Override
	@SuppressWarnings("PMD")
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SteeringFilter that = (SteeringFilter) o;

		if (pattern != null ? !pattern.equals(that.pattern) : that.pattern != null) return false;
		return deliveryService != null ? deliveryService.equals(that.deliveryService) : that.deliveryService == null;

	}

	@Override
	@SuppressWarnings("PMD")
	public int hashCode() {
		int result = pattern != null ? pattern.hashCode() : 0;
		result = 31 * result + (deliveryService != null ? deliveryService.hashCode() : 0);
		return result;
	}
}
