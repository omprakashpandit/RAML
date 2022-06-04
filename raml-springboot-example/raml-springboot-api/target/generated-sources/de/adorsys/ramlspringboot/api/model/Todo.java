
package de.adorsys.ramlspringboot.api.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * A Todo item
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "task",
    "priority"
})
public class Todo {

    /**
     * 
     */
    @JsonProperty("id")
    private Integer id;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("task")
    private String task;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    private Integer priority;

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Todo withId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The task
     */
    @JsonProperty("task")
    public String getTask() {
        return task;
    }

    /**
     * 
     * (Required)
     * 
     * @param task
     *     The task
     */
    @JsonProperty("task")
    public void setTask(String task) {
        this.task = task;
    }

    public Todo withTask(String task) {
        this.task = task;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The priority
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * 
     * (Required)
     * 
     * @param priority
     *     The priority
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Todo withPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(task).append(priority).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Todo) == false) {
            return false;
        }
        Todo rhs = ((Todo) other);
        return new EqualsBuilder().append(id, rhs.id).append(task, rhs.task).append(priority, rhs.priority).isEquals();
    }

}
