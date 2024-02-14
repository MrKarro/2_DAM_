# -*- coding: utf-8 -*-
from odoo import http

'''
class CarpinteriaDcs(http.Controller):
    @http.route('/carpinteria_dcs/carpinteria_dcs', auth='public')
    def index(self, **kw):
        return "Hello, world"

    @http.route('/carpinteria_dcs/carpinteria_dcs/objects', auth='public')
    def list(self, **kw):
        return http.request.render('carpinteria_dcs.listing', {
            'root': '/carpinteria_dcs/carpinteria_dcs',
            'objects': http.request.env['carpinteria_dcs.carpinteria_dcs'].search([]),
        })

    @http.route('/carpinteria_dcs/carpinteria_dcs/objects/<model("carpinteria_dcs.carpinteria_dcs"):obj>', auth='public')
    def object(self, obj, **kw):
        return http.request.render('carpinteria_dcs.object', {
            'object': obj
        })

    '''
