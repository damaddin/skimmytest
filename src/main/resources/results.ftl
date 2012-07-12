<html>
<head>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.21/jquery-ui.min.js"></script>

    <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/hot-sneaks/jquery-ui.css" charset="" />

    <style type="text/css">

        .overlayImg {

        }
    </style>

<script>
$(function() {
    $( ".overlayImg" ).tabs();
});
</script>


</head>
<body>


<table width="100%" height="100%">
    <tr>
        <td colspan="2" height="32">
            Run Report of <b>${suiteName}</b> against <b>${hostName}</b>
        </td>
    </tr>
    <tr>
        <td width="100" valign="top">
            <#list items as item>
               <a href="">${item.key}</a><br/>
            </#list>
        </td>
        <td>

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
                <div id="${item.key}-tabs-1">
                   <img src="${item.failedImgPath}" width="512" />
                </div>
                </#if>

                <div id="${item.key}-tabs-2">
                    <img src="${item.currentImgPath}" width="512" />
                </div>

                <div id="${item.key}-tabs-3">
                    <img src="${item.wantedImgPath}" width="512"  />
                </div>

            </div>
        </#list>

        </td>
    </tr>
</table>

</body>
</html>