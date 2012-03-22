package sample.domain;

import java.io.Serializable;

public class TradeRequest implements Serializable {

	private String ticker;

	private String description;

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((ticker == null) ? 0 : ticker.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TradeRequest other = (TradeRequest) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		}
		else if (!description.equals(other.description)) {
			return false;
		}
		if (ticker == null) {
			if (other.ticker != null) {
				return false;
			}
		}
		else if (!ticker.equals(other.ticker)) {
			return false;
		}
		return true;
	}

}
