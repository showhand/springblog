﻿/*
 Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
 For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.skins.add('kama', (function () {
    var a = 'cke_ui_color';
    return{editor: {css: ['editor.css']}, dialog: {css: ['dialog.css'
    ]}, richcombo: {canGroup: false}, templates: {css: ['templates.css']}, margins: [0, 0, 0, 0
    ], init: function (b) {
        if (b.config.width && !isNaN(b.config.width)) {
            b.config.width -= 12;
        }
        var c = [
        ], d = /\$color/g, e = '/* UI Color Support */.cke_skin_kama .cke_menuitem .cke_icon_wrapper{\tbackground-color: $color !important;\tborder-color: $color !important;}.cke_skin_kama .cke_menuitem a:hover .cke_icon_wrapper,.cke_skin_kama .cke_menuitem a:focus .cke_icon_wrapper,.cke_skin_kama .cke_menuitem a:active .cke_icon_wrapper{\tbackground-color: $color !important;\tborder-color: $color !important;}.cke_skin_kama .cke_menuitem a:hover .cke_label,.cke_skin_kama .cke_menuitem a:focus .cke_label,.cke_skin_kama .cke_menuitem a:active .cke_label{\tbackground-color: $color !important;}.cke_skin_kama .cke_menuitem a.cke_disabled:hover .cke_label,.cke_skin_kama .cke_menuitem a.cke_disabled:focus .cke_label,.cke_skin_kama .cke_menuitem a.cke_disabled:active .cke_label{\tbackground-color: transparent !important;}.cke_skin_kama .cke_menuitem a.cke_disabled:hover .cke_icon_wrapper,.cke_skin_kama .cke_menuitem a.cke_disabled:focus .cke_icon_wrapper,.cke_skin_kama .cke_menuitem a.cke_disabled:active .cke_icon_wrapper{\tbackground-color: $color !important;\tborder-color: $color !important;}.cke_skin_kama .cke_menuitem a.cke_disabled .cke_icon_wrapper{\tbackground-color: $color !important;\tborder-color: $color !important;}.cke_skin_kama .cke_menuseparator{\tbackground-color: $color !important;}.cke_skin_kama .cke_menuitem a:hover,.cke_skin_kama .cke_menuitem a:focus,.cke_skin_kama .cke_menuitem a:active{\tbackground-color: $color !important;}';
        if (CKEDITOR.env.webkit) {
            e = e.split('}').slice(0, -1);
            for (var f = 0; f < e.length; f++) {
                e[f] = e[f].split('{');
            }
        }
        function g(j) {
            var k = j.getById(a);
            if (!k) {
                k = j.getHead().append('style');
                k.setAttribute('id', a);
                k.setAttribute('type', 'text/css');
            }
            return k;
        };
        function h(j, k, l) {
            var m, n, o;
            for (var p = 0; p < j.length; p++) {
                if (CKEDITOR.env.webkit) {
                    for (n = 0; n < k.length; n++) {
                        o = k[n][1];
                        for (m = 0; m < l.length; m++) {
                            o = o.replace(l[m][0], l[m][1]);
                        }
                        j[p].$.sheet.addRule(k[n][0], o);
                    }
                } else {
                    o = k;
                    for (m = 0; m < l.length; m++) {
                        o = o.replace(l[m][0], l[m][1]);
                    }
                    if (CKEDITOR.env.ie) {
                        j[p].$.styleSheet.cssText += o;
                    } else {
                        j[p].$.innerHTML += o;
                    }
                }
            }
        };
        var i = /\$color/g;
        CKEDITOR.tools.extend(b, {uiColor: null, getUiColor: function () {
            return this.uiColor;
        }, setUiColor: function (j) {
            var k, l = g(CKEDITOR.document), m = '.' + b.id, n = [m + ' .cke_wrapper', m
                + '_dialog .cke_dialog_contents', m + '_dialog a.cke_dialog_tab',
                                                                  m + '_dialog .cke_dialog_footer']
                .join(','), o = 'background-color: $color !important;';
            if (CKEDITOR.env.webkit) {
                k = [
                    [n, o]
                ];
            } else {
                k = n + '{' + o + '}';
            }
            return(this.setUiColor = function (p) {
                var q = [
                    [i, p]
                ];
                b.uiColor = p;
                h([l], k, q);
                h(c, e, q);
            })(j);
        }});
        b.on('menuShow', function (j) {
            var k = j.data[0], l = k.element.getElementsByTag('iframe').getItem(0)
                .getFrameDocument();
            if (!l.getById('cke_ui_color')) {
                var m = g(l);
                c.push(m);
                var n = b.getUiColor();
                if (n) {
                    h([m], e, [
                        [i, n]
                    ]);
                }
            }
        });
        if (b.config.uiColor) {
            b.setUiColor(b.config.uiColor);
        }
    }};
})());
(function () {
    CKEDITOR.dialog ? a() : CKEDITOR.on('dialogPluginReady', a);
    function a() {
        CKEDITOR.dialog.on('resize', function (b) {
            var c = b.data, d = c.width, e = c.height, f = c.dialog, g = f.parts.contents;
            if (c.skin != 'kama') {
                return;
            }
            g.setStyles({width: d + 'px', height: e + 'px'});
        });
    };
})();
