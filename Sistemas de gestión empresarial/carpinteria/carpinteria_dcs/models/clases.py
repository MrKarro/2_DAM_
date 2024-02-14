from odoo import models, fields


class material(models.Model):
    _name = 'carpinteria.material'
    _description = 'Modelo para representar los materials de una carpinteria'
    name = fields.Char('Nombre', required=True)
    stock = fields.Integer('Cantidad en stock')
    precio = fields.Integer('Precio', required=True)
    imagen = fields.Binary(string='Imagen')
    disponible = fields.Boolean(string='Disponible')
    tipo = fields.Selection([('No', 'No madera'), ('Ro', 'Roble'), ('Ha', 'Haya'), ('Pi', 'Pino'), ('Ce', 'Cerezo'), ('Ng', 'Nogal'), ('Cd', 'Cedro'), ('Ca', 'Caoba'), ('We', 'Wengue')],
                                string='Tipo', default='No', readonly=True)
    
    producto_ids = fields.Many2many('carpinteria.producto', 'material_id', string='Producto')


class pedido(models.Model):
    _name = 'carpinteria.pedido'
    _description = 'Modelo para representar los pedidos de cada material'
    name = fields.Char('Nombre', required=True)


class producto(models.Model):
    _name = 'carpinteria.producto'
    _description = 'Modelo para representar los producto de cada Material'
    name = fields.Char('Nombre', size=65, required=True)
    descripcion = fields.Text(string='Descripción')
    precio = fields.Integer('Precio')
    
    logo_Producto = fields.Binary(string='Imagen')
    material_id = fields.Many2many('carpinteria.material', string='Material')
    pedido_ids = fields.Many2many('carpinteria.pedido', 'carpinteria_material_Pedido_rel', string='Pedido')


class FichasMaterialReport(models.AbstractModel):
    _name = 'report.carpinteria_dcs.report_imprimir_fichas'
    _description = 'modelo abstracto para imprimir todas las fichas de cada material'

    def _get_report_values(self, docids=None, data=None):
        docids = self.env['carpinteria.material'].search([]).ids
        docs = self.env['carpinteria.material'].search([])
        return {
            'doc_ids': docids,
            'doc_model': self.env['carpinteria.material'],
            'docs': docs,
            'data': data,
        }
