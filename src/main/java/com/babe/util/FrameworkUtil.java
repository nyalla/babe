package com.babe.util;

import com.babe.constants.PortalConstants;

public class FrameworkUtil
{
    public static PortalConstants.DataBases getDataBase(String database)
    {
        switch (database)
        {
            case "mysql":
                return PortalConstants.DataBases.MYSQL;
            case "sql":
                return PortalConstants.DataBases.SQL;
            case "oracle":
                return PortalConstants.DataBases.ORACLE;
            case "postgres":
                return PortalConstants.DataBases.POSTGRES;
            default:
                return null;
        }
    }

    public static PortalConstants.BuildType getBuildType(String build)
    {
        switch (build)
        {
            case "maven":
                return PortalConstants.BuildType.POM;
            case "gradle":
                return PortalConstants.BuildType.GRADLE;
            default:
                return null;
        }
    }
}
