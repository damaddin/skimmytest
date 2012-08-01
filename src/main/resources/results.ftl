<html>
<head>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.21/jquery-ui.min.js"></script>

    <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/hot-sneaks/jquery-ui.css" charset="" />

    <style type="text/css">

        body {
            font-family: Arial, sans-serif;
            font-size: 10pt;
            padding: 0px;
            margin: 0px;
        }

        .anchorSelect {
            border: 1px dashed #ffcc00;
        }

        .resultImg {
            border: 1px solid black;
        }

        .tabsDiv {
            background-color: #B5CFCF;
        }

        .ui-tabs-panel {
            padding: 1px !important;
        }

        a {
            text-decoration: none;
        }

        .overlayImg {

        }
    </style>

<script type="text/javascript">

$(function() {
    $( ".overlayImg" ).tabs();
    $( ".overlayImg" ).hide();
    $( ".overlayImg")[0].show();
});

function showResult(anchor, key) {
    $(".overlayImg").hide();
    $("#" + key).show();

    $(".anchorSelect").removeClass("anchorSelect");
    $(this).addClass("anchorSelect");
    return false;
}
</script>

</head>
<body>

<table width="100%" height="100%">
    <tr>
        <td colspan="2" height="32" style="border-bottom: 2px dashed gray; background-color: #d3d3d3;">
            SkimmyTest: Report of suite <b>${suiteName}</b> against <b>${hostName}</b>
        </td>
    </tr>
    <tr>
        <td width="160" valign="top" style="padding: 0px; border-right: 2px dashed gray;">
            <!-- TODO automatic resize of scroll area -->
            <div style="overflow-y: scroll; height: 700px; padding: 8px;">
            <#list items as item>
                <#if item.failed>
                    <a href="#" onclick="showResult(this, '${item.key}');"><span style="color: #CC0000;">${item.key}</span></a><br/>
                <#else>
                    <a href="#" onclick="showResult(this, '${item.key}');"><span style="color: #00CC00;">${item.key}</a><br/>
                </#if>
                <hr size="1" />
            </#list>
            </div>
        </td>
        <td valign="top">

        <#list items as item>
            <div id="${item.key}" class="overlayImg">
                <ul>
                    <#if item.failed>
                    <li><a href="#${item.key}-tabs-1">Diff</a></li>
                    </#if>
                    <li><a href="#${item.key}-tabs-2">Current</a></li>
                    <li><a href="#${item.key}-tabs-3">Wanted</a></li>
                </ul>

                <#if item.failed>
                <div id="${item.key}-tabs-1" class="tabsDiv">
                   <img src="${item.failedImgPath}" class="resultImg" width="512" />
                </div>
                </#if>

                <div id="${item.key}-tabs-2" class="tabsDiv">
                    <img src="${item.currentImgPath}" class="resultImg" width="512" />
                </div>

                <div id="${item.key}-tabs-3" class="tabsDiv">
                    <img src="${item.wantedImgPath}" class="resultImg" width="512"  />
                </div>

            </div>
        </#list>

        </td>
    </tr>
</table>

</body>
</html>