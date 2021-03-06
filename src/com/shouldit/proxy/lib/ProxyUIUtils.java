package com.shouldit.proxy.lib;

import android.content.Context;

public class ProxyUIUtils
{

	public static String GetStatusTitle(ProxyConfiguration conf, Context callerContext)
	{
		String description;

		switch (conf.getCheckingStatus())
		{
			case CHECKED:
			{
				ProxyStatusItem status = conf.status.getMostRelevantErrorProxyStatusItem();

				if (status != null)
				{
					switch (status.statusCode)
					{
						case PROXY_ENABLED:
							description = callerContext.getResources().getString(R.string.status_title_not_enabled);
							break;

						case PROXY_VALID_HOSTNAME:
							description = callerContext.getResources().getString(R.string.status_title_invalid_host);
							break;

						case PROXY_VALID_PORT:
							description = callerContext.getResources().getString(R.string.status_title_invalid_port);
							break;

						case PROXY_REACHABLE:
							description = callerContext.getResources().getString(R.string.status_title_not_reachable);
							break;

						case WEB_REACHABLE:
							description = callerContext.getResources().getString(R.string.status_title_web_not_reachable);
							break;

						default:
							description = "";
					}
				}
				else
					description = callerContext.getResources().getString(R.string.status_title_enabled);
			}	
			break;

			case CHECKING:
				description = callerContext.getResources().getString(R.string.status_title_checking);
				break;

			default:
				description = "";
				break;
		}

		return description;
	}

	public static String GetStatusDescription(ProxyConfiguration conf, Context callerContext)
	{
		String description;

		switch (conf.getCheckingStatus())
		{
			case CHECKED:
			{
				ProxyStatusItem status = conf.status.getMostRelevantErrorProxyStatusItem();

				if (status != null)
				{
					switch (status.statusCode)
					{
						case PROXY_ENABLED:
							description = callerContext.getResources().getString(R.string.status_description_not_enabled);
							break;

						case PROXY_VALID_HOSTNAME:
							description = callerContext.getResources().getString(R.string.status_description_invalid_host);
							break;

						case PROXY_VALID_PORT:
							description = callerContext.getResources().getString(R.string.status_description_invalid_port);
							break;

						case PROXY_REACHABLE:
							description = callerContext.getResources().getString(R.string.status_description_not_reachable);
							break;
						case WEB_REACHABLE:
							description = callerContext.getResources().getString(R.string.status_description_web_not_reachable);
							break;

						default:
							description = "";
					}
				}
				else
				{
					description = callerContext.getResources().getString(R.string.status_description_enabled);
					description = description + " " + conf.toStatusString();
					break;
				}

			}
			break;

			case CHECKING:
				description = callerContext.getResources().getString(R.string.status_description_checking);
				break;

			default:
				description = "";
				break;
		}

		return description;
	}

	public static String ProxyConfigToStatusString(ProxyConfiguration conf, Context callerContext)
	{
		String message = String.format("%s", conf.toStatusString());

		message += " - " + GetStatusTitle(conf, callerContext);

		return message;
	}
}
