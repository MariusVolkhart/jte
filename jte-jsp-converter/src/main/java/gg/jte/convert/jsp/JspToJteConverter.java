package gg.jte.convert.jsp;

import gg.jte.convert.IoUtils;

import java.nio.file.Path;

public class JspToJteConverter {
    private final Path jspRoot;
    private final Path jteRoot;

    private String defaultImports;

    public JspToJteConverter(Path jspRoot, Path jteRoot) {
        this.jspRoot = jspRoot;
        this.jteRoot = jteRoot;
    }

    public void setDefaultImports(String defaultImports) {
        this.defaultImports = defaultImports;
    }

    public void convertTag(String jspTag, String jteTag) {
        convertTag(jspRoot.resolve(jspTag), jteRoot.resolve(jteTag));
    }

    private void convertTag(Path jspTag, Path jteTag) {
        JspTagParser parser = new JspTagParser();
        String jte = parser.convert(IoUtils.readFile(jspTag), defaultImports);

        IoUtils.writeFile(jteTag, jte);
    }
}
