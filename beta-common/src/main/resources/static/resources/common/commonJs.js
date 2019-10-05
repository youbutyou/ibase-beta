
/**
 * js 公用文件
 */
document.write('<script type="text/javascript" charset="UTF-8" src="/resources/css/layui/layui.js"></script>');
document.write('<script type="text/javascript" charset="UTF-8" src="/resources/js/jquery-3.4.1.min.js"></script>');

/**
 * 自定义公用文件
 */
document.write('<script type="text/javascript" charset="UTF-8" src="/resources/js/toolbar.js"></script>');
document.write('<script type="text/javascript" charset="UTF-8" src="/resources/js/component.js"></script>');
document.write('<script type="text/javascript" charset="UTF-8" src="/resources/js/constant.js"></script>');

/**
 * 自定义工具栏
 */
document.write('<script type="text/html" id="tool_bar"></script>');
document.write('<script type="text/html" id="row_bar"></script>');

/**
 * 数据状态表格模板
 */
document.write('    <script type="text/html" id="stateTpl">\n' +
    '        {{# if(d.state === \'state_001\'){ }}\n' +
    '            <span style="color: green;">启用</span>\n' +
    '        {{# } else if(d.state === \'state_002\'){ }}\n' +
    '            <span style="color: red;">停用</span>\n' +
    '        {{# } else if(d.state === null){ }}\n' +
    '            ' +
    '        {{# } else{ }}\n' +
    '            {{d.state}}\n' +
    '        {{# } }}\n' +
    '    </script>');
/**
 * 文件类型表格模板
 */
document.write('    <script type="text/html" id="fileTypeTpl">\n' +
    '        {{# if(d.fileType === \'file_001\'){ }}\n' +
    '            文件' +
    '        {{# } else if(d.fileType === \'file_002\'){ }}\n' +
    '            目录' +
    '        {{# } else if(d.fileType === null){ }}\n' +
    '            ' +
    '        {{# } else{ }}\n' +
    '            {{d.fileType}}\n' +
    '        {{# } }}\n' +
    '    </script>');

