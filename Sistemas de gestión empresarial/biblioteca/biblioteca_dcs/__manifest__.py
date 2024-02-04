# -*- coding: utf-8 -*-
{
    'name': "biblioteca_dcs",

    'summary': """
        Módulo creado para las practicas de la unidad 9 de SGE""",

    'description': """
        Este es un módulo creado para generar y aprender como funciona Odoo y hacer las prácticas dispuestas en el tema 9 de SGE
    """,

    'author': "David Carro",
    'website': "https://www.iesvenancioblanco.es/",
    'application': True,
    'installable': True,

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/16.0/odoo/addons/base/data/ir_module_category_data.xml
    # for the full list
    'category': 'Uncategorized',
    'version': '0.1',

    # any module necessary for this one to work correctly
    'depends': ['base'],

    # always loaded
    'data': [

        'security/grupos.xml',
        'security/ir.model.access.csv',
        'views/vistas.xml',
        'views/views.xml',
        'views/templates.xml',
        'demo/demo.xml',
        'reports/informes.xml'
    ],
    # only loaded in demonstration mode
    'demo': [
        'demo/demo.xml',
    ],


}
