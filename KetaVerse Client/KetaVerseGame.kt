import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2

class MyGdxGame : ApplicationAdapter() {
    private lateinit var shapeRenderer: ShapeRenderer
    private lateinit var pointPosition: Vector2

    override fun create() {
        shapeRenderer = ShapeRenderer()
        pointPosition = Vector2(Gdx.graphics.width / 2f, Gdx.graphics.height / 2f)
    }

    override fun render() {
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        // Handle input
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) pointPosition.y += 5
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) pointPosition.y -= 5
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) pointPosition.x -= 5
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) pointPosition.x += 5

        // Draw grid
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line)
        shapeRenderer.color = Color.DARK_GRAY
        for (i in 0 until Gdx.graphics.width step 20) {
            shapeRenderer.line(i.toFloat(), 0f, i.toFloat(), Gdx.graphics.height.toFloat())
        }
        for (i in 0 until Gdx.graphics.height step 20) {
            shapeRenderer.line(0f, i.toFloat(), Gdx.graphics.width.toFloat(), i.toFloat())
        }

        // Draw point
        shapeRenderer.color = Color.RED
        shapeRenderer.circle(pointPosition.x, pointPosition.y, 10f)
        shapeRenderer.end()
    }

    override fun dispose() {
        shapeRenderer.dispose()
    }
}