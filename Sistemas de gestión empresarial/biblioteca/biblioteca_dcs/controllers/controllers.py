# -*- coding: utf-8 -*-
from odoo import http

'''
class BibliotecaDcs(http.Controller):
    @http.route('/Biblioteca_dcs/Biblioteca_dcs', auth='public')
    def index(self, **kw):
        return "Hello, world"

    @http.route('/Biblioteca_dcs/Biblioteca_dcs/objects', auth='public')
    def list(self, **kw):
        return http.request.render('Biblioteca_dcs.listing', {
            'root': '/Biblioteca_dcs/Biblioteca_dcs',
            'objects': http.request.env['Biblioteca_dcs.Biblioteca_dcs'].search([]),
        })

    @http.route('/Biblioteca_dcs/Biblioteca_dcs/objects/<model("Biblioteca_dcs.Biblioteca_dcs"):obj>', auth='public')
    def object(self, obj, **kw):
        return http.request.render('Biblioteca_dcs.object', {
            'object': obj
        })

    '''
