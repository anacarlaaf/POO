import streamlit as st
import plotly.express as px

# Dados fornecidos
saldo = 16042.949993133545
receita = 23600.0
despesa = -7557.05

categorias = {
    "educacao": 895.0,
    "transporte": 259.1,
    "saude": 975.5,
    "lazer": 573.2,
    "diversos": 104.25,
    "moradia": 4750.0
}

# Configuração da página
st.set_page_config(layout="wide", page_title="Dashboard Financeiro")

st.title("Dashboard Financeiro")

# Cards
col1, col2, col3 = st.columns(3)

col1.metric("Saldo", f"R$ {saldo:,.2f}")
col2.metric("Receita", f"R$ {receita:,.2f}")
col3.metric("Despesa", f"R$ {abs(despesa):,.2f}")

st.markdown("---")

# Gráfico de barras e pizza lado a lado
colA, colB = st.columns(2)

# Gráfico de barras horizontais das categorias
fig_bar = px.bar(
    x=list(categorias.values()),
    y=list(categorias.keys()),
    orientation='h',
    title="Despesas por Categoria"
)
colA.plotly_chart(fig_bar, width='stretch')

# Gráfico de pizza Receita vs Despesa
fig_pizza = px.pie(
    names=["Receita", "Despesa"],
    values=[receita, abs(despesa)],
    title="Receita x Despesa"
)
colB.plotly_chart(fig_pizza, width='stretch')
